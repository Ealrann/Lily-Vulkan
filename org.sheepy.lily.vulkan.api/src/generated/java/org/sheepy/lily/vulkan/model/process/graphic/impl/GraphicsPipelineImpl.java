/**
 */
package org.sheepy.lily.vulkan.model.process.graphic.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.sheepy.lily.core.model.builder.Buildable;
import org.sheepy.lily.core.model.builder.Builder;
import org.sheepy.lily.core.model.builder.BuilderPackage;
import org.sheepy.lily.vulkan.model.IResourceContainer;
import org.sheepy.lily.vulkan.model.ResourcePkg;
import org.sheepy.lily.vulkan.model.VulkanPackage;
import org.sheepy.lily.vulkan.model.process.IProcessPart;
import org.sheepy.lily.vulkan.model.process.TaskPkg;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline;
import org.sheepy.lily.vulkan.model.process.graphic.VertexDescriptor;
import org.sheepy.lily.vulkan.model.resource.DescriptorSet;
import org.sheepy.lily.vulkan.model.resource.Shader;
import org.sheepy.vulkan.model.enumeration.ECommandStage;
import org.sheepy.vulkan.model.graphicpipeline.ColorBlend;
import org.sheepy.vulkan.model.graphicpipeline.DynamicState;
import org.sheepy.vulkan.model.graphicpipeline.InputAssembly;
import org.sheepy.vulkan.model.graphicpipeline.Rasterizer;
import org.sheepy.vulkan.model.graphicpipeline.ViewportState;
import org.sheepy.vulkan.model.pipeline.PushConstantRange;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Graphics Pipeline</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicsPipelineImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicsPipelineImpl#getResourcePkg <em>Resource Pkg</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicsPipelineImpl#isEnabled <em>Enabled</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicsPipelineImpl#getStage <em>Stage</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicsPipelineImpl#getPushConstantRanges <em>Push Constant Ranges</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicsPipelineImpl#getDescriptorSetRef <em>Descriptor Set Ref</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicsPipelineImpl#getDescriptorSet <em>Descriptor Set</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicsPipelineImpl#getTaskPkg <em>Task Pkg</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicsPipelineImpl#getBuilder <em>Builder</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicsPipelineImpl#getShaders <em>Shaders</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicsPipelineImpl#getViewportState <em>Viewport State</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicsPipelineImpl#getInputAssembly <em>Input Assembly</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicsPipelineImpl#getRasterizer <em>Rasterizer</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicsPipelineImpl#getColorBlend <em>Color Blend</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicsPipelineImpl#getDynamicState <em>Dynamic State</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicsPipelineImpl#getSubpass <em>Subpass</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicsPipelineImpl#getVertexDescriptor <em>Vertex Descriptor</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GraphicsPipelineImpl extends MinimalEObjectImpl.Container implements GraphicsPipeline
{
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;
	/**
	 * The cached value of the '{@link #getResourcePkg() <em>Resource Pkg</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourcePkg()
	 * @generated
	 * @ordered
	 */
	protected ResourcePkg resourcePkg;
	/**
	 * The default value of the '{@link #isEnabled() <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENABLED_EDEFAULT = true;
	/**
	 * The cached value of the '{@link #isEnabled() <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabled()
	 * @generated
	 * @ordered
	 */
	protected boolean enabled = ENABLED_EDEFAULT;
	/**
	 * The default value of the '{@link #getStage() <em>Stage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStage()
	 * @generated
	 * @ordered
	 */
	protected static final ECommandStage STAGE_EDEFAULT = ECommandStage.RENDER;
	/**
	 * The cached value of the '{@link #getStage() <em>Stage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStage()
	 * @generated
	 * @ordered
	 */
	protected ECommandStage stage = STAGE_EDEFAULT;
	/**
	 * The cached value of the '{@link #getPushConstantRanges() <em>Push Constant Ranges</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPushConstantRanges()
	 * @generated
	 * @ordered
	 */
	protected EList<PushConstantRange> pushConstantRanges;
	/**
	 * The cached value of the '{@link #getDescriptorSetRef() <em>Descriptor Set Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescriptorSetRef()
	 * @generated
	 * @ordered
	 */
	protected DescriptorSet descriptorSetRef;
	/**
	 * The cached value of the '{@link #getDescriptorSet() <em>Descriptor Set</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescriptorSet()
	 * @generated
	 * @ordered
	 */
	protected DescriptorSet descriptorSet;
	/**
	 * The cached value of the '{@link #getTaskPkg() <em>Task Pkg</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTaskPkg()
	 * @generated
	 * @ordered
	 */
	protected TaskPkg taskPkg;
	/**
	 * The cached value of the '{@link #getBuilder() <em>Builder</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBuilder()
	 * @generated
	 * @ordered
	 */
	protected Builder<GraphicsPipeline> builder;
	/**
	 * The cached value of the '{@link #getShaders() <em>Shaders</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getShaders()
	 * @generated
	 * @ordered
	 */
	protected EList<Shader> shaders;
	/**
	 * The cached value of the '{@link #getViewportState() <em>Viewport State</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getViewportState()
	 * @generated
	 * @ordered
	 */
	protected ViewportState viewportState;
	/**
	 * The cached value of the '{@link #getInputAssembly() <em>Input Assembly</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputAssembly()
	 * @generated
	 * @ordered
	 */
	protected InputAssembly inputAssembly;
	/**
	 * The cached value of the '{@link #getRasterizer() <em>Rasterizer</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRasterizer()
	 * @generated
	 * @ordered
	 */
	protected Rasterizer rasterizer;
	/**
	 * The cached value of the '{@link #getColorBlend() <em>Color Blend</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColorBlend()
	 * @generated
	 * @ordered
	 */
	protected ColorBlend colorBlend;
	/**
	 * The cached value of the '{@link #getDynamicState() <em>Dynamic State</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDynamicState()
	 * @generated
	 * @ordered
	 */
	protected DynamicState dynamicState;
	/**
	 * The default value of the '{@link #getSubpass() <em>Subpass</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubpass()
	 * @generated
	 * @ordered
	 */
	protected static final int SUBPASS_EDEFAULT = 0;
	/**
	 * The cached value of the '{@link #getSubpass() <em>Subpass</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubpass()
	 * @generated
	 * @ordered
	 */
	protected int subpass = SUBPASS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getVertexDescriptor() <em>Vertex Descriptor</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVertexDescriptor()
	 * @generated
	 * @ordered
	 */
	protected VertexDescriptor vertexDescriptor;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraphicsPipelineImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return GraphicPackage.Literals.GRAPHICS_PIPELINE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName()
	{
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName)
	{
		String oldName = name;
		name = newName;
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				GraphicPackage.GRAPHICS_PIPELINE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourcePkg getResourcePkg()
	{
		return resourcePkg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetResourcePkg(ResourcePkg newResourcePkg, NotificationChain msgs)
	{
		ResourcePkg oldResourcePkg = resourcePkg;
		resourcePkg = newResourcePkg;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					GraphicPackage.GRAPHICS_PIPELINE__RESOURCE_PKG, oldResourcePkg, newResourcePkg);
			if (msgs == null) msgs = notification;
			else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setResourcePkg(ResourcePkg newResourcePkg)
	{
		if (newResourcePkg != resourcePkg)
		{
			NotificationChain msgs = null;
			if (resourcePkg != null) msgs = ((InternalEObject) resourcePkg).eInverseRemove(this,
					EOPPOSITE_FEATURE_BASE - GraphicPackage.GRAPHICS_PIPELINE__RESOURCE_PKG, null,
					msgs);
			if (newResourcePkg != null) msgs = ((InternalEObject) newResourcePkg).eInverseAdd(this,
					EOPPOSITE_FEATURE_BASE - GraphicPackage.GRAPHICS_PIPELINE__RESOURCE_PKG, null,
					msgs);
			msgs = basicSetResourcePkg(newResourcePkg, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				GraphicPackage.GRAPHICS_PIPELINE__RESOURCE_PKG, newResourcePkg, newResourcePkg));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isEnabled()
	{
		return enabled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEnabled(boolean newEnabled)
	{
		boolean oldEnabled = enabled;
		enabled = newEnabled;
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				GraphicPackage.GRAPHICS_PIPELINE__ENABLED, oldEnabled, enabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ECommandStage getStage()
	{
		return stage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStage(ECommandStage newStage)
	{
		ECommandStage oldStage = stage;
		stage = newStage == null ? STAGE_EDEFAULT : newStage;
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				GraphicPackage.GRAPHICS_PIPELINE__STAGE, oldStage, stage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<PushConstantRange> getPushConstantRanges()
	{
		if (pushConstantRanges == null)
		{
			pushConstantRanges = new EObjectContainmentEList<PushConstantRange>(
					PushConstantRange.class, this,
					GraphicPackage.GRAPHICS_PIPELINE__PUSH_CONSTANT_RANGES);
		}
		return pushConstantRanges;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DescriptorSet getDescriptorSetRef()
	{
		if (descriptorSetRef != null && descriptorSetRef.eIsProxy())
		{
			InternalEObject oldDescriptorSetRef = (InternalEObject) descriptorSetRef;
			descriptorSetRef = (DescriptorSet) eResolveProxy(oldDescriptorSetRef);
			if (descriptorSetRef != oldDescriptorSetRef)
			{
				if (eNotificationRequired()) eNotify(new ENotificationImpl(this,
						Notification.RESOLVE, GraphicPackage.GRAPHICS_PIPELINE__DESCRIPTOR_SET_REF,
						oldDescriptorSetRef, descriptorSetRef));
			}
		}
		return descriptorSetRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DescriptorSet basicGetDescriptorSetRef()
	{
		return descriptorSetRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDescriptorSetRef(DescriptorSet newDescriptorSetRef)
	{
		DescriptorSet oldDescriptorSetRef = descriptorSetRef;
		descriptorSetRef = newDescriptorSetRef;
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				GraphicPackage.GRAPHICS_PIPELINE__DESCRIPTOR_SET_REF, oldDescriptorSetRef,
				descriptorSetRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DescriptorSet getDescriptorSet()
	{
		return descriptorSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDescriptorSet(	DescriptorSet newDescriptorSet,
													NotificationChain msgs)
	{
		DescriptorSet oldDescriptorSet = descriptorSet;
		descriptorSet = newDescriptorSet;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					GraphicPackage.GRAPHICS_PIPELINE__DESCRIPTOR_SET, oldDescriptorSet,
					newDescriptorSet);
			if (msgs == null) msgs = notification;
			else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDescriptorSet(DescriptorSet newDescriptorSet)
	{
		if (newDescriptorSet != descriptorSet)
		{
			NotificationChain msgs = null;
			if (descriptorSet != null) msgs = ((InternalEObject) descriptorSet).eInverseRemove(this,
					EOPPOSITE_FEATURE_BASE - GraphicPackage.GRAPHICS_PIPELINE__DESCRIPTOR_SET, null,
					msgs);
			if (newDescriptorSet != null)
				msgs = ((InternalEObject) newDescriptorSet).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - GraphicPackage.GRAPHICS_PIPELINE__DESCRIPTOR_SET,
						null, msgs);
			msgs = basicSetDescriptorSet(newDescriptorSet, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				GraphicPackage.GRAPHICS_PIPELINE__DESCRIPTOR_SET, newDescriptorSet,
				newDescriptorSet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TaskPkg getTaskPkg()
	{
		return taskPkg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTaskPkg(TaskPkg newTaskPkg, NotificationChain msgs)
	{
		TaskPkg oldTaskPkg = taskPkg;
		taskPkg = newTaskPkg;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					GraphicPackage.GRAPHICS_PIPELINE__TASK_PKG, oldTaskPkg, newTaskPkg);
			if (msgs == null) msgs = notification;
			else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTaskPkg(TaskPkg newTaskPkg)
	{
		if (newTaskPkg != taskPkg)
		{
			NotificationChain msgs = null;
			if (taskPkg != null) msgs = ((InternalEObject) taskPkg).eInverseRemove(this,
					EOPPOSITE_FEATURE_BASE - GraphicPackage.GRAPHICS_PIPELINE__TASK_PKG, null,
					msgs);
			if (newTaskPkg != null) msgs = ((InternalEObject) newTaskPkg).eInverseAdd(this,
					EOPPOSITE_FEATURE_BASE - GraphicPackage.GRAPHICS_PIPELINE__TASK_PKG, null,
					msgs);
			msgs = basicSetTaskPkg(newTaskPkg, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				GraphicPackage.GRAPHICS_PIPELINE__TASK_PKG, newTaskPkg, newTaskPkg));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Builder<GraphicsPipeline> getBuilder()
	{
		return builder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBuilder(	Builder<GraphicsPipeline> newBuilder,
												NotificationChain msgs)
	{
		Builder<GraphicsPipeline> oldBuilder = builder;
		builder = newBuilder;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					GraphicPackage.GRAPHICS_PIPELINE__BUILDER, oldBuilder, newBuilder);
			if (msgs == null) msgs = notification;
			else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBuilder(Builder<GraphicsPipeline> newBuilder)
	{
		if (newBuilder != builder)
		{
			NotificationChain msgs = null;
			if (builder != null) msgs = ((InternalEObject) builder).eInverseRemove(this,
					EOPPOSITE_FEATURE_BASE - GraphicPackage.GRAPHICS_PIPELINE__BUILDER, null, msgs);
			if (newBuilder != null) msgs = ((InternalEObject) newBuilder).eInverseAdd(this,
					EOPPOSITE_FEATURE_BASE - GraphicPackage.GRAPHICS_PIPELINE__BUILDER, null, msgs);
			msgs = basicSetBuilder(newBuilder, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				GraphicPackage.GRAPHICS_PIPELINE__BUILDER, newBuilder, newBuilder));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Shader> getShaders()
	{
		if (shaders == null)
		{
			shaders = new EObjectResolvingEList<Shader>(Shader.class, this,
					GraphicPackage.GRAPHICS_PIPELINE__SHADERS);
		}
		return shaders;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ViewportState getViewportState()
	{
		return viewportState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetViewportState(	ViewportState newViewportState,
													NotificationChain msgs)
	{
		ViewportState oldViewportState = viewportState;
		viewportState = newViewportState;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					GraphicPackage.GRAPHICS_PIPELINE__VIEWPORT_STATE, oldViewportState,
					newViewportState);
			if (msgs == null) msgs = notification;
			else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setViewportState(ViewportState newViewportState)
	{
		if (newViewportState != viewportState)
		{
			NotificationChain msgs = null;
			if (viewportState != null) msgs = ((InternalEObject) viewportState).eInverseRemove(this,
					EOPPOSITE_FEATURE_BASE - GraphicPackage.GRAPHICS_PIPELINE__VIEWPORT_STATE, null,
					msgs);
			if (newViewportState != null)
				msgs = ((InternalEObject) newViewportState).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - GraphicPackage.GRAPHICS_PIPELINE__VIEWPORT_STATE,
						null, msgs);
			msgs = basicSetViewportState(newViewportState, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				GraphicPackage.GRAPHICS_PIPELINE__VIEWPORT_STATE, newViewportState,
				newViewportState));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public InputAssembly getInputAssembly()
	{
		return inputAssembly;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInputAssembly(	InputAssembly newInputAssembly,
													NotificationChain msgs)
	{
		InputAssembly oldInputAssembly = inputAssembly;
		inputAssembly = newInputAssembly;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					GraphicPackage.GRAPHICS_PIPELINE__INPUT_ASSEMBLY, oldInputAssembly,
					newInputAssembly);
			if (msgs == null) msgs = notification;
			else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInputAssembly(InputAssembly newInputAssembly)
	{
		if (newInputAssembly != inputAssembly)
		{
			NotificationChain msgs = null;
			if (inputAssembly != null) msgs = ((InternalEObject) inputAssembly).eInverseRemove(this,
					EOPPOSITE_FEATURE_BASE - GraphicPackage.GRAPHICS_PIPELINE__INPUT_ASSEMBLY, null,
					msgs);
			if (newInputAssembly != null)
				msgs = ((InternalEObject) newInputAssembly).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - GraphicPackage.GRAPHICS_PIPELINE__INPUT_ASSEMBLY,
						null, msgs);
			msgs = basicSetInputAssembly(newInputAssembly, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				GraphicPackage.GRAPHICS_PIPELINE__INPUT_ASSEMBLY, newInputAssembly,
				newInputAssembly));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Rasterizer getRasterizer()
	{
		return rasterizer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRasterizer(Rasterizer newRasterizer, NotificationChain msgs)
	{
		Rasterizer oldRasterizer = rasterizer;
		rasterizer = newRasterizer;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					GraphicPackage.GRAPHICS_PIPELINE__RASTERIZER, oldRasterizer, newRasterizer);
			if (msgs == null) msgs = notification;
			else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRasterizer(Rasterizer newRasterizer)
	{
		if (newRasterizer != rasterizer)
		{
			NotificationChain msgs = null;
			if (rasterizer != null) msgs = ((InternalEObject) rasterizer).eInverseRemove(this,
					EOPPOSITE_FEATURE_BASE - GraphicPackage.GRAPHICS_PIPELINE__RASTERIZER, null,
					msgs);
			if (newRasterizer != null) msgs = ((InternalEObject) newRasterizer).eInverseAdd(this,
					EOPPOSITE_FEATURE_BASE - GraphicPackage.GRAPHICS_PIPELINE__RASTERIZER, null,
					msgs);
			msgs = basicSetRasterizer(newRasterizer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				GraphicPackage.GRAPHICS_PIPELINE__RASTERIZER, newRasterizer, newRasterizer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ColorBlend getColorBlend()
	{
		return colorBlend;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetColorBlend(ColorBlend newColorBlend, NotificationChain msgs)
	{
		ColorBlend oldColorBlend = colorBlend;
		colorBlend = newColorBlend;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					GraphicPackage.GRAPHICS_PIPELINE__COLOR_BLEND, oldColorBlend, newColorBlend);
			if (msgs == null) msgs = notification;
			else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setColorBlend(ColorBlend newColorBlend)
	{
		if (newColorBlend != colorBlend)
		{
			NotificationChain msgs = null;
			if (colorBlend != null) msgs = ((InternalEObject) colorBlend).eInverseRemove(this,
					EOPPOSITE_FEATURE_BASE - GraphicPackage.GRAPHICS_PIPELINE__COLOR_BLEND, null,
					msgs);
			if (newColorBlend != null) msgs = ((InternalEObject) newColorBlend).eInverseAdd(this,
					EOPPOSITE_FEATURE_BASE - GraphicPackage.GRAPHICS_PIPELINE__COLOR_BLEND, null,
					msgs);
			msgs = basicSetColorBlend(newColorBlend, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				GraphicPackage.GRAPHICS_PIPELINE__COLOR_BLEND, newColorBlend, newColorBlend));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DynamicState getDynamicState()
	{
		return dynamicState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDynamicState(	DynamicState newDynamicState,
													NotificationChain msgs)
	{
		DynamicState oldDynamicState = dynamicState;
		dynamicState = newDynamicState;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					GraphicPackage.GRAPHICS_PIPELINE__DYNAMIC_STATE, oldDynamicState,
					newDynamicState);
			if (msgs == null) msgs = notification;
			else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDynamicState(DynamicState newDynamicState)
	{
		if (newDynamicState != dynamicState)
		{
			NotificationChain msgs = null;
			if (dynamicState != null) msgs = ((InternalEObject) dynamicState).eInverseRemove(this,
					EOPPOSITE_FEATURE_BASE - GraphicPackage.GRAPHICS_PIPELINE__DYNAMIC_STATE, null,
					msgs);
			if (newDynamicState != null)
				msgs = ((InternalEObject) newDynamicState).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - GraphicPackage.GRAPHICS_PIPELINE__DYNAMIC_STATE,
						null, msgs);
			msgs = basicSetDynamicState(newDynamicState, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				GraphicPackage.GRAPHICS_PIPELINE__DYNAMIC_STATE, newDynamicState, newDynamicState));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getSubpass()
	{
		return subpass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSubpass(int newSubpass)
	{
		int oldSubpass = subpass;
		subpass = newSubpass;
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				GraphicPackage.GRAPHICS_PIPELINE__SUBPASS, oldSubpass, subpass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public VertexDescriptor getVertexDescriptor()
	{
		return vertexDescriptor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetVertexDescriptor(	VertexDescriptor newVertexDescriptor,
														NotificationChain msgs)
	{
		VertexDescriptor oldVertexDescriptor = vertexDescriptor;
		vertexDescriptor = newVertexDescriptor;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					GraphicPackage.GRAPHICS_PIPELINE__VERTEX_DESCRIPTOR, oldVertexDescriptor,
					newVertexDescriptor);
			if (msgs == null) msgs = notification;
			else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVertexDescriptor(VertexDescriptor newVertexDescriptor)
	{
		if (newVertexDescriptor != vertexDescriptor)
		{
			NotificationChain msgs = null;
			if (vertexDescriptor != null) msgs = ((InternalEObject) vertexDescriptor)
					.eInverseRemove(this,
							EOPPOSITE_FEATURE_BASE
									- GraphicPackage.GRAPHICS_PIPELINE__VERTEX_DESCRIPTOR,
							null, msgs);
			if (newVertexDescriptor != null) msgs = ((InternalEObject) newVertexDescriptor)
					.eInverseAdd(this,
							EOPPOSITE_FEATURE_BASE
									- GraphicPackage.GRAPHICS_PIPELINE__VERTEX_DESCRIPTOR,
							null, msgs);
			msgs = basicSetVertexDescriptor(newVertexDescriptor, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				GraphicPackage.GRAPHICS_PIPELINE__VERTEX_DESCRIPTOR, newVertexDescriptor,
				newVertexDescriptor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
											int featureID,
											NotificationChain msgs)
	{
		switch (featureID)
		{
		case GraphicPackage.GRAPHICS_PIPELINE__RESOURCE_PKG:
			return basicSetResourcePkg(null, msgs);
		case GraphicPackage.GRAPHICS_PIPELINE__PUSH_CONSTANT_RANGES:
			return ((InternalEList<?>) getPushConstantRanges()).basicRemove(otherEnd, msgs);
		case GraphicPackage.GRAPHICS_PIPELINE__DESCRIPTOR_SET:
			return basicSetDescriptorSet(null, msgs);
		case GraphicPackage.GRAPHICS_PIPELINE__TASK_PKG:
			return basicSetTaskPkg(null, msgs);
		case GraphicPackage.GRAPHICS_PIPELINE__BUILDER:
			return basicSetBuilder(null, msgs);
		case GraphicPackage.GRAPHICS_PIPELINE__VIEWPORT_STATE:
			return basicSetViewportState(null, msgs);
		case GraphicPackage.GRAPHICS_PIPELINE__INPUT_ASSEMBLY:
			return basicSetInputAssembly(null, msgs);
		case GraphicPackage.GRAPHICS_PIPELINE__RASTERIZER:
			return basicSetRasterizer(null, msgs);
		case GraphicPackage.GRAPHICS_PIPELINE__COLOR_BLEND:
			return basicSetColorBlend(null, msgs);
		case GraphicPackage.GRAPHICS_PIPELINE__DYNAMIC_STATE:
			return basicSetDynamicState(null, msgs);
		case GraphicPackage.GRAPHICS_PIPELINE__VERTEX_DESCRIPTOR:
			return basicSetVertexDescriptor(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType)
	{
		switch (featureID)
		{
		case GraphicPackage.GRAPHICS_PIPELINE__NAME:
			return getName();
		case GraphicPackage.GRAPHICS_PIPELINE__RESOURCE_PKG:
			return getResourcePkg();
		case GraphicPackage.GRAPHICS_PIPELINE__ENABLED:
			return isEnabled();
		case GraphicPackage.GRAPHICS_PIPELINE__STAGE:
			return getStage();
		case GraphicPackage.GRAPHICS_PIPELINE__PUSH_CONSTANT_RANGES:
			return getPushConstantRanges();
		case GraphicPackage.GRAPHICS_PIPELINE__DESCRIPTOR_SET_REF:
			if (resolve) return getDescriptorSetRef();
			return basicGetDescriptorSetRef();
		case GraphicPackage.GRAPHICS_PIPELINE__DESCRIPTOR_SET:
			return getDescriptorSet();
		case GraphicPackage.GRAPHICS_PIPELINE__TASK_PKG:
			return getTaskPkg();
		case GraphicPackage.GRAPHICS_PIPELINE__BUILDER:
			return getBuilder();
		case GraphicPackage.GRAPHICS_PIPELINE__SHADERS:
			return getShaders();
		case GraphicPackage.GRAPHICS_PIPELINE__VIEWPORT_STATE:
			return getViewportState();
		case GraphicPackage.GRAPHICS_PIPELINE__INPUT_ASSEMBLY:
			return getInputAssembly();
		case GraphicPackage.GRAPHICS_PIPELINE__RASTERIZER:
			return getRasterizer();
		case GraphicPackage.GRAPHICS_PIPELINE__COLOR_BLEND:
			return getColorBlend();
		case GraphicPackage.GRAPHICS_PIPELINE__DYNAMIC_STATE:
			return getDynamicState();
		case GraphicPackage.GRAPHICS_PIPELINE__SUBPASS:
			return getSubpass();
		case GraphicPackage.GRAPHICS_PIPELINE__VERTEX_DESCRIPTOR:
			return getVertexDescriptor();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
		case GraphicPackage.GRAPHICS_PIPELINE__NAME:
			setName((String) newValue);
			return;
		case GraphicPackage.GRAPHICS_PIPELINE__RESOURCE_PKG:
			setResourcePkg((ResourcePkg) newValue);
			return;
		case GraphicPackage.GRAPHICS_PIPELINE__ENABLED:
			setEnabled((Boolean) newValue);
			return;
		case GraphicPackage.GRAPHICS_PIPELINE__STAGE:
			setStage((ECommandStage) newValue);
			return;
		case GraphicPackage.GRAPHICS_PIPELINE__PUSH_CONSTANT_RANGES:
			getPushConstantRanges().clear();
			getPushConstantRanges().addAll((Collection<? extends PushConstantRange>) newValue);
			return;
		case GraphicPackage.GRAPHICS_PIPELINE__DESCRIPTOR_SET_REF:
			setDescriptorSetRef((DescriptorSet) newValue);
			return;
		case GraphicPackage.GRAPHICS_PIPELINE__DESCRIPTOR_SET:
			setDescriptorSet((DescriptorSet) newValue);
			return;
		case GraphicPackage.GRAPHICS_PIPELINE__TASK_PKG:
			setTaskPkg((TaskPkg) newValue);
			return;
		case GraphicPackage.GRAPHICS_PIPELINE__BUILDER:
			setBuilder((Builder<GraphicsPipeline>) newValue);
			return;
		case GraphicPackage.GRAPHICS_PIPELINE__SHADERS:
			getShaders().clear();
			getShaders().addAll((Collection<? extends Shader>) newValue);
			return;
		case GraphicPackage.GRAPHICS_PIPELINE__VIEWPORT_STATE:
			setViewportState((ViewportState) newValue);
			return;
		case GraphicPackage.GRAPHICS_PIPELINE__INPUT_ASSEMBLY:
			setInputAssembly((InputAssembly) newValue);
			return;
		case GraphicPackage.GRAPHICS_PIPELINE__RASTERIZER:
			setRasterizer((Rasterizer) newValue);
			return;
		case GraphicPackage.GRAPHICS_PIPELINE__COLOR_BLEND:
			setColorBlend((ColorBlend) newValue);
			return;
		case GraphicPackage.GRAPHICS_PIPELINE__DYNAMIC_STATE:
			setDynamicState((DynamicState) newValue);
			return;
		case GraphicPackage.GRAPHICS_PIPELINE__SUBPASS:
			setSubpass((Integer) newValue);
			return;
		case GraphicPackage.GRAPHICS_PIPELINE__VERTEX_DESCRIPTOR:
			setVertexDescriptor((VertexDescriptor) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID)
	{
		switch (featureID)
		{
		case GraphicPackage.GRAPHICS_PIPELINE__NAME:
			setName(NAME_EDEFAULT);
			return;
		case GraphicPackage.GRAPHICS_PIPELINE__RESOURCE_PKG:
			setResourcePkg((ResourcePkg) null);
			return;
		case GraphicPackage.GRAPHICS_PIPELINE__ENABLED:
			setEnabled(ENABLED_EDEFAULT);
			return;
		case GraphicPackage.GRAPHICS_PIPELINE__STAGE:
			setStage(STAGE_EDEFAULT);
			return;
		case GraphicPackage.GRAPHICS_PIPELINE__PUSH_CONSTANT_RANGES:
			getPushConstantRanges().clear();
			return;
		case GraphicPackage.GRAPHICS_PIPELINE__DESCRIPTOR_SET_REF:
			setDescriptorSetRef((DescriptorSet) null);
			return;
		case GraphicPackage.GRAPHICS_PIPELINE__DESCRIPTOR_SET:
			setDescriptorSet((DescriptorSet) null);
			return;
		case GraphicPackage.GRAPHICS_PIPELINE__TASK_PKG:
			setTaskPkg((TaskPkg) null);
			return;
		case GraphicPackage.GRAPHICS_PIPELINE__BUILDER:
			setBuilder((Builder<GraphicsPipeline>) null);
			return;
		case GraphicPackage.GRAPHICS_PIPELINE__SHADERS:
			getShaders().clear();
			return;
		case GraphicPackage.GRAPHICS_PIPELINE__VIEWPORT_STATE:
			setViewportState((ViewportState) null);
			return;
		case GraphicPackage.GRAPHICS_PIPELINE__INPUT_ASSEMBLY:
			setInputAssembly((InputAssembly) null);
			return;
		case GraphicPackage.GRAPHICS_PIPELINE__RASTERIZER:
			setRasterizer((Rasterizer) null);
			return;
		case GraphicPackage.GRAPHICS_PIPELINE__COLOR_BLEND:
			setColorBlend((ColorBlend) null);
			return;
		case GraphicPackage.GRAPHICS_PIPELINE__DYNAMIC_STATE:
			setDynamicState((DynamicState) null);
			return;
		case GraphicPackage.GRAPHICS_PIPELINE__SUBPASS:
			setSubpass(SUBPASS_EDEFAULT);
			return;
		case GraphicPackage.GRAPHICS_PIPELINE__VERTEX_DESCRIPTOR:
			setVertexDescriptor((VertexDescriptor) null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID)
	{
		switch (featureID)
		{
		case GraphicPackage.GRAPHICS_PIPELINE__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		case GraphicPackage.GRAPHICS_PIPELINE__RESOURCE_PKG:
			return resourcePkg != null;
		case GraphicPackage.GRAPHICS_PIPELINE__ENABLED:
			return enabled != ENABLED_EDEFAULT;
		case GraphicPackage.GRAPHICS_PIPELINE__STAGE:
			return stage != STAGE_EDEFAULT;
		case GraphicPackage.GRAPHICS_PIPELINE__PUSH_CONSTANT_RANGES:
			return pushConstantRanges != null && !pushConstantRanges.isEmpty();
		case GraphicPackage.GRAPHICS_PIPELINE__DESCRIPTOR_SET_REF:
			return descriptorSetRef != null;
		case GraphicPackage.GRAPHICS_PIPELINE__DESCRIPTOR_SET:
			return descriptorSet != null;
		case GraphicPackage.GRAPHICS_PIPELINE__TASK_PKG:
			return taskPkg != null;
		case GraphicPackage.GRAPHICS_PIPELINE__BUILDER:
			return builder != null;
		case GraphicPackage.GRAPHICS_PIPELINE__SHADERS:
			return shaders != null && !shaders.isEmpty();
		case GraphicPackage.GRAPHICS_PIPELINE__VIEWPORT_STATE:
			return viewportState != null;
		case GraphicPackage.GRAPHICS_PIPELINE__INPUT_ASSEMBLY:
			return inputAssembly != null;
		case GraphicPackage.GRAPHICS_PIPELINE__RASTERIZER:
			return rasterizer != null;
		case GraphicPackage.GRAPHICS_PIPELINE__COLOR_BLEND:
			return colorBlend != null;
		case GraphicPackage.GRAPHICS_PIPELINE__DYNAMIC_STATE:
			return dynamicState != null;
		case GraphicPackage.GRAPHICS_PIPELINE__SUBPASS:
			return subpass != SUBPASS_EDEFAULT;
		case GraphicPackage.GRAPHICS_PIPELINE__VERTEX_DESCRIPTOR:
			return vertexDescriptor != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass)
	{
		if (baseClass == IResourceContainer.class)
		{
			switch (derivedFeatureID)
			{
			case GraphicPackage.GRAPHICS_PIPELINE__RESOURCE_PKG:
				return VulkanPackage.IRESOURCE_CONTAINER__RESOURCE_PKG;
			default:
				return -1;
			}
		}
		if (baseClass == IProcessPart.class)
		{
			switch (derivedFeatureID)
			{
			default:
				return -1;
			}
		}
		if (baseClass == Buildable.class)
		{
			switch (derivedFeatureID)
			{
			case GraphicPackage.GRAPHICS_PIPELINE__BUILDER:
				return BuilderPackage.BUILDABLE__BUILDER;
			default:
				return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass)
	{
		if (baseClass == IResourceContainer.class)
		{
			switch (baseFeatureID)
			{
			case VulkanPackage.IRESOURCE_CONTAINER__RESOURCE_PKG:
				return GraphicPackage.GRAPHICS_PIPELINE__RESOURCE_PKG;
			default:
				return -1;
			}
		}
		if (baseClass == IProcessPart.class)
		{
			switch (baseFeatureID)
			{
			default:
				return -1;
			}
		}
		if (baseClass == Buildable.class)
		{
			switch (baseFeatureID)
			{
			case BuilderPackage.BUILDABLE__BUILDER:
				return GraphicPackage.GRAPHICS_PIPELINE__BUILDER;
			default:
				return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString()
	{
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", enabled: ");
		result.append(enabled);
		result.append(", stage: ");
		result.append(stage);
		result.append(", subpass: ");
		result.append(subpass);
		result.append(')');
		return result.toString();
	}

} //GraphicsPipelineImpl
