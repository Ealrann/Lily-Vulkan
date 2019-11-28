/**
 */
package org.sheepy.lily.vulkan.model.process.graphic.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.sheepy.lily.core.api.adapter.LilyEObject;
import org.sheepy.lily.core.model.maintainer.Maintainable;
import org.sheepy.lily.core.model.maintainer.Maintainer;
import org.sheepy.lily.core.model.maintainer.MaintainerPackage;

import org.sheepy.lily.vulkan.model.DescriptorPkg;
import org.sheepy.lily.vulkan.model.IResourceContainer;
import org.sheepy.lily.vulkan.model.ResourcePkg;
import org.sheepy.lily.vulkan.model.VulkanPackage;

import org.sheepy.lily.vulkan.model.process.IProcessPart;
import org.sheepy.lily.vulkan.model.process.TaskPkg;

import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline;
import org.sheepy.lily.vulkan.model.process.graphic.VertexInputState;

import org.sheepy.lily.vulkan.model.resource.ConstantBuffer;
import org.sheepy.lily.vulkan.model.resource.DescriptorSetPkg;
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
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicsPipelineImpl#getDescriptorPkg <em>Descriptor Pkg</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicsPipelineImpl#isEnabled <em>Enabled</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicsPipelineImpl#getStage <em>Stage</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicsPipelineImpl#getPushConstantRanges <em>Push Constant Ranges</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicsPipelineImpl#getSpecializationData <em>Specialization Data</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicsPipelineImpl#getDescriptorSetPkg <em>Descriptor Set Pkg</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicsPipelineImpl#getTaskPkg <em>Task Pkg</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicsPipelineImpl#getMaintainer <em>Maintainer</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicsPipelineImpl#getShaders <em>Shaders</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicsPipelineImpl#getViewportState <em>Viewport State</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicsPipelineImpl#getInputAssembly <em>Input Assembly</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicsPipelineImpl#getRasterizer <em>Rasterizer</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicsPipelineImpl#getColorBlend <em>Color Blend</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicsPipelineImpl#getDynamicState <em>Dynamic State</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicsPipelineImpl#getSubpass <em>Subpass</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicsPipelineImpl#getVertexInputState <em>Vertex Input State</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GraphicsPipelineImpl extends LilyEObject implements GraphicsPipeline
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
	 * The cached value of the '{@link #getDescriptorPkg() <em>Descriptor Pkg</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescriptorPkg()
	 * @generated
	 * @ordered
	 */
	protected DescriptorPkg descriptorPkg;

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
	 * The cached value of the '{@link #getSpecializationData() <em>Specialization Data</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpecializationData()
	 * @generated
	 * @ordered
	 */
	protected ConstantBuffer specializationData;

	/**
	 * The cached value of the '{@link #getDescriptorSetPkg() <em>Descriptor Set Pkg</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescriptorSetPkg()
	 * @generated
	 * @ordered
	 */
	protected DescriptorSetPkg descriptorSetPkg;

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
	 * The cached value of the '{@link #getMaintainer() <em>Maintainer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaintainer()
	 * @generated
	 * @ordered
	 */
	protected Maintainer<GraphicsPipeline> maintainer;

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
	 * The cached value of the '{@link #getVertexInputState() <em>Vertex Input State</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVertexInputState()
	 * @generated
	 * @ordered
	 */
	protected VertexInputState vertexInputState;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GraphicsPipelineImpl()
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
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.GRAPHICS_PIPELINE__NAME, oldName, name));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GraphicPackage.GRAPHICS_PIPELINE__RESOURCE_PKG, oldResourcePkg, newResourcePkg);
			if (msgs == null) msgs = notification; else msgs.add(notification);
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
			if (resourcePkg != null)
				msgs = ((InternalEObject)resourcePkg).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GraphicPackage.GRAPHICS_PIPELINE__RESOURCE_PKG, null, msgs);
			if (newResourcePkg != null)
				msgs = ((InternalEObject)newResourcePkg).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GraphicPackage.GRAPHICS_PIPELINE__RESOURCE_PKG, null, msgs);
			msgs = basicSetResourcePkg(newResourcePkg, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.GRAPHICS_PIPELINE__RESOURCE_PKG, newResourcePkg, newResourcePkg));
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
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.GRAPHICS_PIPELINE__ENABLED, oldEnabled, enabled));
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
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.GRAPHICS_PIPELINE__STAGE, oldStage, stage));
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
			pushConstantRanges = new EObjectContainmentEList<PushConstantRange>(PushConstantRange.class, this, GraphicPackage.GRAPHICS_PIPELINE__PUSH_CONSTANT_RANGES);
		}
		return pushConstantRanges;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ConstantBuffer getSpecializationData()
	{
		if (specializationData != null && ((EObject)specializationData).eIsProxy())
		{
			InternalEObject oldSpecializationData = (InternalEObject)specializationData;
			specializationData = (ConstantBuffer)eResolveProxy(oldSpecializationData);
			if (specializationData != oldSpecializationData)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GraphicPackage.GRAPHICS_PIPELINE__SPECIALIZATION_DATA, oldSpecializationData, specializationData));
			}
		}
		return specializationData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConstantBuffer basicGetSpecializationData()
	{
		return specializationData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSpecializationData(ConstantBuffer newSpecializationData)
	{
		ConstantBuffer oldSpecializationData = specializationData;
		specializationData = newSpecializationData;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.GRAPHICS_PIPELINE__SPECIALIZATION_DATA, oldSpecializationData, specializationData));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DescriptorSetPkg getDescriptorSetPkg()
	{
		return descriptorSetPkg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDescriptorSetPkg(DescriptorSetPkg newDescriptorSetPkg, NotificationChain msgs)
	{
		DescriptorSetPkg oldDescriptorSetPkg = descriptorSetPkg;
		descriptorSetPkg = newDescriptorSetPkg;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GraphicPackage.GRAPHICS_PIPELINE__DESCRIPTOR_SET_PKG, oldDescriptorSetPkg, newDescriptorSetPkg);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDescriptorSetPkg(DescriptorSetPkg newDescriptorSetPkg)
	{
		if (newDescriptorSetPkg != descriptorSetPkg)
		{
			NotificationChain msgs = null;
			if (descriptorSetPkg != null)
				msgs = ((InternalEObject)descriptorSetPkg).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GraphicPackage.GRAPHICS_PIPELINE__DESCRIPTOR_SET_PKG, null, msgs);
			if (newDescriptorSetPkg != null)
				msgs = ((InternalEObject)newDescriptorSetPkg).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GraphicPackage.GRAPHICS_PIPELINE__DESCRIPTOR_SET_PKG, null, msgs);
			msgs = basicSetDescriptorSetPkg(newDescriptorSetPkg, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.GRAPHICS_PIPELINE__DESCRIPTOR_SET_PKG, newDescriptorSetPkg, newDescriptorSetPkg));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GraphicPackage.GRAPHICS_PIPELINE__TASK_PKG, oldTaskPkg, newTaskPkg);
			if (msgs == null) msgs = notification; else msgs.add(notification);
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
			if (taskPkg != null)
				msgs = ((InternalEObject)taskPkg).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GraphicPackage.GRAPHICS_PIPELINE__TASK_PKG, null, msgs);
			if (newTaskPkg != null)
				msgs = ((InternalEObject)newTaskPkg).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GraphicPackage.GRAPHICS_PIPELINE__TASK_PKG, null, msgs);
			msgs = basicSetTaskPkg(newTaskPkg, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.GRAPHICS_PIPELINE__TASK_PKG, newTaskPkg, newTaskPkg));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DescriptorPkg getDescriptorPkg()
	{
		return descriptorPkg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDescriptorPkg(DescriptorPkg newDescriptorPkg, NotificationChain msgs)
	{
		DescriptorPkg oldDescriptorPkg = descriptorPkg;
		descriptorPkg = newDescriptorPkg;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GraphicPackage.GRAPHICS_PIPELINE__DESCRIPTOR_PKG, oldDescriptorPkg, newDescriptorPkg);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDescriptorPkg(DescriptorPkg newDescriptorPkg)
	{
		if (newDescriptorPkg != descriptorPkg)
		{
			NotificationChain msgs = null;
			if (descriptorPkg != null)
				msgs = ((InternalEObject)descriptorPkg).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GraphicPackage.GRAPHICS_PIPELINE__DESCRIPTOR_PKG, null, msgs);
			if (newDescriptorPkg != null)
				msgs = ((InternalEObject)newDescriptorPkg).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GraphicPackage.GRAPHICS_PIPELINE__DESCRIPTOR_PKG, null, msgs);
			msgs = basicSetDescriptorPkg(newDescriptorPkg, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.GRAPHICS_PIPELINE__DESCRIPTOR_PKG, newDescriptorPkg, newDescriptorPkg));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Maintainer<GraphicsPipeline> getMaintainer()
	{
		if (maintainer != null && ((EObject)maintainer).eIsProxy())
		{
			InternalEObject oldMaintainer = (InternalEObject)maintainer;
			maintainer = (Maintainer<GraphicsPipeline>)eResolveProxy(oldMaintainer);
			if (maintainer != oldMaintainer)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GraphicPackage.GRAPHICS_PIPELINE__MAINTAINER, oldMaintainer, maintainer));
			}
		}
		return maintainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Maintainer<GraphicsPipeline> basicGetMaintainer()
	{
		return maintainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMaintainer(Maintainer<GraphicsPipeline> newMaintainer, NotificationChain msgs)
	{
		Maintainer<GraphicsPipeline> oldMaintainer = maintainer;
		maintainer = newMaintainer;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GraphicPackage.GRAPHICS_PIPELINE__MAINTAINER, oldMaintainer, newMaintainer);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMaintainer(Maintainer<GraphicsPipeline> newMaintainer)
	{
		if (newMaintainer != maintainer)
		{
			NotificationChain msgs = null;
			if (maintainer != null)
				msgs = ((InternalEObject)maintainer).eInverseRemove(this, MaintainerPackage.MAINTAINER__MAINTAINED, Maintainer.class, msgs);
			if (newMaintainer != null)
				msgs = ((InternalEObject)newMaintainer).eInverseAdd(this, MaintainerPackage.MAINTAINER__MAINTAINED, Maintainer.class, msgs);
			msgs = basicSetMaintainer(newMaintainer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.GRAPHICS_PIPELINE__MAINTAINER, newMaintainer, newMaintainer));
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
			shaders = new EObjectResolvingEList<Shader>(Shader.class, this, GraphicPackage.GRAPHICS_PIPELINE__SHADERS);
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
	public NotificationChain basicSetViewportState(ViewportState newViewportState, NotificationChain msgs)
	{
		ViewportState oldViewportState = viewportState;
		viewportState = newViewportState;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GraphicPackage.GRAPHICS_PIPELINE__VIEWPORT_STATE, oldViewportState, newViewportState);
			if (msgs == null) msgs = notification; else msgs.add(notification);
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
			if (viewportState != null)
				msgs = ((InternalEObject)viewportState).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GraphicPackage.GRAPHICS_PIPELINE__VIEWPORT_STATE, null, msgs);
			if (newViewportState != null)
				msgs = ((InternalEObject)newViewportState).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GraphicPackage.GRAPHICS_PIPELINE__VIEWPORT_STATE, null, msgs);
			msgs = basicSetViewportState(newViewportState, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.GRAPHICS_PIPELINE__VIEWPORT_STATE, newViewportState, newViewportState));
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
	public NotificationChain basicSetInputAssembly(InputAssembly newInputAssembly, NotificationChain msgs)
	{
		InputAssembly oldInputAssembly = inputAssembly;
		inputAssembly = newInputAssembly;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GraphicPackage.GRAPHICS_PIPELINE__INPUT_ASSEMBLY, oldInputAssembly, newInputAssembly);
			if (msgs == null) msgs = notification; else msgs.add(notification);
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
			if (inputAssembly != null)
				msgs = ((InternalEObject)inputAssembly).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GraphicPackage.GRAPHICS_PIPELINE__INPUT_ASSEMBLY, null, msgs);
			if (newInputAssembly != null)
				msgs = ((InternalEObject)newInputAssembly).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GraphicPackage.GRAPHICS_PIPELINE__INPUT_ASSEMBLY, null, msgs);
			msgs = basicSetInputAssembly(newInputAssembly, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.GRAPHICS_PIPELINE__INPUT_ASSEMBLY, newInputAssembly, newInputAssembly));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GraphicPackage.GRAPHICS_PIPELINE__RASTERIZER, oldRasterizer, newRasterizer);
			if (msgs == null) msgs = notification; else msgs.add(notification);
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
			if (rasterizer != null)
				msgs = ((InternalEObject)rasterizer).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GraphicPackage.GRAPHICS_PIPELINE__RASTERIZER, null, msgs);
			if (newRasterizer != null)
				msgs = ((InternalEObject)newRasterizer).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GraphicPackage.GRAPHICS_PIPELINE__RASTERIZER, null, msgs);
			msgs = basicSetRasterizer(newRasterizer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.GRAPHICS_PIPELINE__RASTERIZER, newRasterizer, newRasterizer));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GraphicPackage.GRAPHICS_PIPELINE__COLOR_BLEND, oldColorBlend, newColorBlend);
			if (msgs == null) msgs = notification; else msgs.add(notification);
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
			if (colorBlend != null)
				msgs = ((InternalEObject)colorBlend).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GraphicPackage.GRAPHICS_PIPELINE__COLOR_BLEND, null, msgs);
			if (newColorBlend != null)
				msgs = ((InternalEObject)newColorBlend).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GraphicPackage.GRAPHICS_PIPELINE__COLOR_BLEND, null, msgs);
			msgs = basicSetColorBlend(newColorBlend, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.GRAPHICS_PIPELINE__COLOR_BLEND, newColorBlend, newColorBlend));
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
	public NotificationChain basicSetDynamicState(DynamicState newDynamicState, NotificationChain msgs)
	{
		DynamicState oldDynamicState = dynamicState;
		dynamicState = newDynamicState;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GraphicPackage.GRAPHICS_PIPELINE__DYNAMIC_STATE, oldDynamicState, newDynamicState);
			if (msgs == null) msgs = notification; else msgs.add(notification);
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
			if (dynamicState != null)
				msgs = ((InternalEObject)dynamicState).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GraphicPackage.GRAPHICS_PIPELINE__DYNAMIC_STATE, null, msgs);
			if (newDynamicState != null)
				msgs = ((InternalEObject)newDynamicState).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GraphicPackage.GRAPHICS_PIPELINE__DYNAMIC_STATE, null, msgs);
			msgs = basicSetDynamicState(newDynamicState, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.GRAPHICS_PIPELINE__DYNAMIC_STATE, newDynamicState, newDynamicState));
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
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.GRAPHICS_PIPELINE__SUBPASS, oldSubpass, subpass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public VertexInputState getVertexInputState()
	{
		return vertexInputState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetVertexInputState(VertexInputState newVertexInputState, NotificationChain msgs)
	{
		VertexInputState oldVertexInputState = vertexInputState;
		vertexInputState = newVertexInputState;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GraphicPackage.GRAPHICS_PIPELINE__VERTEX_INPUT_STATE, oldVertexInputState, newVertexInputState);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVertexInputState(VertexInputState newVertexInputState)
	{
		if (newVertexInputState != vertexInputState)
		{
			NotificationChain msgs = null;
			if (vertexInputState != null)
				msgs = ((InternalEObject)vertexInputState).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GraphicPackage.GRAPHICS_PIPELINE__VERTEX_INPUT_STATE, null, msgs);
			if (newVertexInputState != null)
				msgs = ((InternalEObject)newVertexInputState).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GraphicPackage.GRAPHICS_PIPELINE__VERTEX_INPUT_STATE, null, msgs);
			msgs = basicSetVertexInputState(newVertexInputState, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.GRAPHICS_PIPELINE__VERTEX_INPUT_STATE, newVertexInputState, newVertexInputState));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case GraphicPackage.GRAPHICS_PIPELINE__MAINTAINER:
				if (maintainer != null)
					msgs = ((InternalEObject)maintainer).eInverseRemove(this, MaintainerPackage.MAINTAINER__MAINTAINED, Maintainer.class, msgs);
				return basicSetMaintainer((Maintainer<GraphicsPipeline>)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case GraphicPackage.GRAPHICS_PIPELINE__RESOURCE_PKG:
				return basicSetResourcePkg(null, msgs);
			case GraphicPackage.GRAPHICS_PIPELINE__DESCRIPTOR_PKG:
				return basicSetDescriptorPkg(null, msgs);
			case GraphicPackage.GRAPHICS_PIPELINE__PUSH_CONSTANT_RANGES:
				return ((InternalEList<?>)getPushConstantRanges()).basicRemove(otherEnd, msgs);
			case GraphicPackage.GRAPHICS_PIPELINE__DESCRIPTOR_SET_PKG:
				return basicSetDescriptorSetPkg(null, msgs);
			case GraphicPackage.GRAPHICS_PIPELINE__TASK_PKG:
				return basicSetTaskPkg(null, msgs);
			case GraphicPackage.GRAPHICS_PIPELINE__MAINTAINER:
				return basicSetMaintainer(null, msgs);
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
			case GraphicPackage.GRAPHICS_PIPELINE__VERTEX_INPUT_STATE:
				return basicSetVertexInputState(null, msgs);
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
			case GraphicPackage.GRAPHICS_PIPELINE__DESCRIPTOR_PKG:
				return getDescriptorPkg();
			case GraphicPackage.GRAPHICS_PIPELINE__ENABLED:
				return isEnabled();
			case GraphicPackage.GRAPHICS_PIPELINE__STAGE:
				return getStage();
			case GraphicPackage.GRAPHICS_PIPELINE__PUSH_CONSTANT_RANGES:
				return getPushConstantRanges();
			case GraphicPackage.GRAPHICS_PIPELINE__SPECIALIZATION_DATA:
				if (resolve) return getSpecializationData();
				return basicGetSpecializationData();
			case GraphicPackage.GRAPHICS_PIPELINE__DESCRIPTOR_SET_PKG:
				return getDescriptorSetPkg();
			case GraphicPackage.GRAPHICS_PIPELINE__TASK_PKG:
				return getTaskPkg();
			case GraphicPackage.GRAPHICS_PIPELINE__MAINTAINER:
				if (resolve) return getMaintainer();
				return basicGetMaintainer();
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
			case GraphicPackage.GRAPHICS_PIPELINE__VERTEX_INPUT_STATE:
				return getVertexInputState();
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
				setName((String)newValue);
				return;
			case GraphicPackage.GRAPHICS_PIPELINE__RESOURCE_PKG:
				setResourcePkg((ResourcePkg)newValue);
				return;
			case GraphicPackage.GRAPHICS_PIPELINE__DESCRIPTOR_PKG:
				setDescriptorPkg((DescriptorPkg)newValue);
				return;
			case GraphicPackage.GRAPHICS_PIPELINE__ENABLED:
				setEnabled((Boolean)newValue);
				return;
			case GraphicPackage.GRAPHICS_PIPELINE__STAGE:
				setStage((ECommandStage)newValue);
				return;
			case GraphicPackage.GRAPHICS_PIPELINE__PUSH_CONSTANT_RANGES:
				getPushConstantRanges().clear();
				getPushConstantRanges().addAll((Collection<? extends PushConstantRange>)newValue);
				return;
			case GraphicPackage.GRAPHICS_PIPELINE__SPECIALIZATION_DATA:
				setSpecializationData((ConstantBuffer)newValue);
				return;
			case GraphicPackage.GRAPHICS_PIPELINE__DESCRIPTOR_SET_PKG:
				setDescriptorSetPkg((DescriptorSetPkg)newValue);
				return;
			case GraphicPackage.GRAPHICS_PIPELINE__TASK_PKG:
				setTaskPkg((TaskPkg)newValue);
				return;
			case GraphicPackage.GRAPHICS_PIPELINE__MAINTAINER:
				setMaintainer((Maintainer<GraphicsPipeline>)newValue);
				return;
			case GraphicPackage.GRAPHICS_PIPELINE__SHADERS:
				getShaders().clear();
				getShaders().addAll((Collection<? extends Shader>)newValue);
				return;
			case GraphicPackage.GRAPHICS_PIPELINE__VIEWPORT_STATE:
				setViewportState((ViewportState)newValue);
				return;
			case GraphicPackage.GRAPHICS_PIPELINE__INPUT_ASSEMBLY:
				setInputAssembly((InputAssembly)newValue);
				return;
			case GraphicPackage.GRAPHICS_PIPELINE__RASTERIZER:
				setRasterizer((Rasterizer)newValue);
				return;
			case GraphicPackage.GRAPHICS_PIPELINE__COLOR_BLEND:
				setColorBlend((ColorBlend)newValue);
				return;
			case GraphicPackage.GRAPHICS_PIPELINE__DYNAMIC_STATE:
				setDynamicState((DynamicState)newValue);
				return;
			case GraphicPackage.GRAPHICS_PIPELINE__SUBPASS:
				setSubpass((Integer)newValue);
				return;
			case GraphicPackage.GRAPHICS_PIPELINE__VERTEX_INPUT_STATE:
				setVertexInputState((VertexInputState)newValue);
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
				setResourcePkg((ResourcePkg)null);
				return;
			case GraphicPackage.GRAPHICS_PIPELINE__DESCRIPTOR_PKG:
				setDescriptorPkg((DescriptorPkg)null);
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
			case GraphicPackage.GRAPHICS_PIPELINE__SPECIALIZATION_DATA:
				setSpecializationData((ConstantBuffer)null);
				return;
			case GraphicPackage.GRAPHICS_PIPELINE__DESCRIPTOR_SET_PKG:
				setDescriptorSetPkg((DescriptorSetPkg)null);
				return;
			case GraphicPackage.GRAPHICS_PIPELINE__TASK_PKG:
				setTaskPkg((TaskPkg)null);
				return;
			case GraphicPackage.GRAPHICS_PIPELINE__MAINTAINER:
				setMaintainer((Maintainer<GraphicsPipeline>)null);
				return;
			case GraphicPackage.GRAPHICS_PIPELINE__SHADERS:
				getShaders().clear();
				return;
			case GraphicPackage.GRAPHICS_PIPELINE__VIEWPORT_STATE:
				setViewportState((ViewportState)null);
				return;
			case GraphicPackage.GRAPHICS_PIPELINE__INPUT_ASSEMBLY:
				setInputAssembly((InputAssembly)null);
				return;
			case GraphicPackage.GRAPHICS_PIPELINE__RASTERIZER:
				setRasterizer((Rasterizer)null);
				return;
			case GraphicPackage.GRAPHICS_PIPELINE__COLOR_BLEND:
				setColorBlend((ColorBlend)null);
				return;
			case GraphicPackage.GRAPHICS_PIPELINE__DYNAMIC_STATE:
				setDynamicState((DynamicState)null);
				return;
			case GraphicPackage.GRAPHICS_PIPELINE__SUBPASS:
				setSubpass(SUBPASS_EDEFAULT);
				return;
			case GraphicPackage.GRAPHICS_PIPELINE__VERTEX_INPUT_STATE:
				setVertexInputState((VertexInputState)null);
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
			case GraphicPackage.GRAPHICS_PIPELINE__DESCRIPTOR_PKG:
				return descriptorPkg != null;
			case GraphicPackage.GRAPHICS_PIPELINE__ENABLED:
				return enabled != ENABLED_EDEFAULT;
			case GraphicPackage.GRAPHICS_PIPELINE__STAGE:
				return stage != STAGE_EDEFAULT;
			case GraphicPackage.GRAPHICS_PIPELINE__PUSH_CONSTANT_RANGES:
				return pushConstantRanges != null && !pushConstantRanges.isEmpty();
			case GraphicPackage.GRAPHICS_PIPELINE__SPECIALIZATION_DATA:
				return specializationData != null;
			case GraphicPackage.GRAPHICS_PIPELINE__DESCRIPTOR_SET_PKG:
				return descriptorSetPkg != null;
			case GraphicPackage.GRAPHICS_PIPELINE__TASK_PKG:
				return taskPkg != null;
			case GraphicPackage.GRAPHICS_PIPELINE__MAINTAINER:
				return maintainer != null;
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
			case GraphicPackage.GRAPHICS_PIPELINE__VERTEX_INPUT_STATE:
				return vertexInputState != null;
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
				case GraphicPackage.GRAPHICS_PIPELINE__RESOURCE_PKG: return VulkanPackage.IRESOURCE_CONTAINER__RESOURCE_PKG;
				case GraphicPackage.GRAPHICS_PIPELINE__DESCRIPTOR_PKG: return VulkanPackage.IRESOURCE_CONTAINER__DESCRIPTOR_PKG;
				default: return -1;
			}
		}
		if (baseClass == IProcessPart.class)
		{
			switch (derivedFeatureID)
			{
				default: return -1;
			}
		}
		if (baseClass == Maintainable.class)
		{
			switch (derivedFeatureID)
			{
				case GraphicPackage.GRAPHICS_PIPELINE__MAINTAINER: return MaintainerPackage.MAINTAINABLE__MAINTAINER;
				default: return -1;
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
				case VulkanPackage.IRESOURCE_CONTAINER__RESOURCE_PKG: return GraphicPackage.GRAPHICS_PIPELINE__RESOURCE_PKG;
				case VulkanPackage.IRESOURCE_CONTAINER__DESCRIPTOR_PKG: return GraphicPackage.GRAPHICS_PIPELINE__DESCRIPTOR_PKG;
				default: return -1;
			}
		}
		if (baseClass == IProcessPart.class)
		{
			switch (baseFeatureID)
			{
				default: return -1;
			}
		}
		if (baseClass == Maintainable.class)
		{
			switch (baseFeatureID)
			{
				case MaintainerPackage.MAINTAINABLE__MAINTAINER: return GraphicPackage.GRAPHICS_PIPELINE__MAINTAINER;
				default: return -1;
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
