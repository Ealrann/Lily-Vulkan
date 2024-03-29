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
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.sheepy.lily.core.api.model.LilyEObject;
import org.sheepy.lily.core.model.application.ICompositor;
import org.sheepy.lily.core.model.types.LNamedElement;
import org.sheepy.lily.core.model.types.TypesPackage;
import org.sheepy.lily.vulkan.model.DescriptorPkg;
import org.sheepy.lily.vulkan.model.VulkanResourcePkg;
import org.sheepy.lily.vulkan.model.process.PipelinePkg;
import org.sheepy.lily.vulkan.model.process.ProcessExtensionPkg;
import org.sheepy.lily.vulkan.model.process.graphic.AttachmentPkg;
import org.sheepy.lily.vulkan.model.process.graphic.AttachmentRefPkg;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.lily.vulkan.model.process.graphic.Subpass;
import org.sheepy.vulkan.model.enumeration.EAccess;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Subpass</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.SubpassImpl#getResourcePkg <em>Resource Pkg</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.SubpassImpl#getDescriptorPkg <em>Descriptor Pkg</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.SubpassImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.SubpassImpl#getAttachmentRefPkg <em>Attachment Ref Pkg</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.SubpassImpl#getAttachmentPkg <em>Attachment Pkg</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.SubpassImpl#getSubpassIndex <em>Subpass Index</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.SubpassImpl#getPipelinePkg <em>Pipeline Pkg</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.SubpassImpl#getBindPoint <em>Bind Point</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.SubpassImpl#getCompositor <em>Compositor</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.SubpassImpl#getWaitForStage <em>Wait For Stage</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.SubpassImpl#getSyncStage <em>Sync Stage</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.SubpassImpl#getFinishStage <em>Finish Stage</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.SubpassImpl#getWaitForAccesses <em>Wait For Accesses</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.SubpassImpl#getSyncAccesses <em>Sync Accesses</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.SubpassImpl#getFinishAccesses <em>Finish Accesses</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.SubpassImpl#getExtensionPkg <em>Extension Pkg</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.SubpassImpl#isEnabled <em>Enabled</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SubpassImpl extends LilyEObject implements Subpass
{
	/**
	 * The cached value of the '{@link #getResourcePkg() <em>Resource Pkg</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourcePkg()
	 * @generated
	 * @ordered
	 */
	protected VulkanResourcePkg resourcePkg;

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
	 * The cached value of the '{@link #getAttachmentRefPkg() <em>Attachment Ref Pkg</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttachmentRefPkg()
	 * @generated
	 * @ordered
	 */
	protected AttachmentRefPkg attachmentRefPkg;

	/**
	 * The cached value of the '{@link #getAttachmentPkg() <em>Attachment Pkg</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttachmentPkg()
	 * @generated
	 * @ordered
	 */
	protected AttachmentPkg attachmentPkg;

	/**
	 * The default value of the '{@link #getSubpassIndex() <em>Subpass Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubpassIndex()
	 * @generated
	 * @ordered
	 */
	protected static final int SUBPASS_INDEX_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSubpassIndex() <em>Subpass Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubpassIndex()
	 * @generated
	 * @ordered
	 */
	protected int subpassIndex = SUBPASS_INDEX_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPipelinePkg() <em>Pipeline Pkg</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPipelinePkg()
	 * @generated
	 * @ordered
	 */
	protected PipelinePkg pipelinePkg;

	/**
	 * The default value of the '{@link #getBindPoint() <em>Bind Point</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBindPoint()
	 * @generated
	 * @ordered
	 */
	protected static final int BIND_POINT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getBindPoint() <em>Bind Point</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBindPoint()
	 * @generated
	 * @ordered
	 */
	protected int bindPoint = BIND_POINT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getCompositor() <em>Compositor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompositor()
	 * @generated
	 * @ordered
	 */
	protected ICompositor compositor;

	/**
	 * The default value of the '{@link #getWaitForStage() <em>Wait For Stage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWaitForStage()
	 * @generated
	 * @ordered
	 */
	protected static final EPipelineStage WAIT_FOR_STAGE_EDEFAULT = EPipelineStage.BOTTOM_OF_PIPE_BIT;

	/**
	 * The cached value of the '{@link #getWaitForStage() <em>Wait For Stage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWaitForStage()
	 * @generated
	 * @ordered
	 */
	protected EPipelineStage waitForStage = WAIT_FOR_STAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getSyncStage() <em>Sync Stage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSyncStage()
	 * @generated
	 * @ordered
	 */
	protected static final EPipelineStage SYNC_STAGE_EDEFAULT = EPipelineStage.TOP_OF_PIPE_BIT;

	/**
	 * The cached value of the '{@link #getSyncStage() <em>Sync Stage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSyncStage()
	 * @generated
	 * @ordered
	 */
	protected EPipelineStage syncStage = SYNC_STAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getFinishStage() <em>Finish Stage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFinishStage()
	 * @generated
	 * @ordered
	 */
	protected static final EPipelineStage FINISH_STAGE_EDEFAULT = EPipelineStage.BOTTOM_OF_PIPE_BIT;

	/**
	 * The cached value of the '{@link #getFinishStage() <em>Finish Stage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFinishStage()
	 * @generated
	 * @ordered
	 */
	protected EPipelineStage finishStage = FINISH_STAGE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getWaitForAccesses() <em>Wait For Accesses</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWaitForAccesses()
	 * @generated
	 * @ordered
	 */
	protected EList<EAccess> waitForAccesses;

	/**
	 * The cached value of the '{@link #getSyncAccesses() <em>Sync Accesses</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSyncAccesses()
	 * @generated
	 * @ordered
	 */
	protected EList<EAccess> syncAccesses;

	/**
	 * The cached value of the '{@link #getFinishAccesses() <em>Finish Accesses</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFinishAccesses()
	 * @generated
	 * @ordered
	 */
	protected EList<EAccess> finishAccesses;

	/**
	 * The cached value of the '{@link #getExtensionPkg() <em>Extension Pkg</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtensionPkg()
	 * @generated
	 * @ordered
	 */
	protected ProcessExtensionPkg extensionPkg;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SubpassImpl()
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
		return GraphicPackage.Literals.SUBPASS;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GraphicPackage.SUBPASS__DESCRIPTOR_PKG, oldDescriptorPkg, newDescriptorPkg);
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
				msgs = ((InternalEObject)descriptorPkg).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GraphicPackage.SUBPASS__DESCRIPTOR_PKG, null, msgs);
			if (newDescriptorPkg != null)
				msgs = ((InternalEObject)newDescriptorPkg).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GraphicPackage.SUBPASS__DESCRIPTOR_PKG, null, msgs);
			msgs = basicSetDescriptorPkg(newDescriptorPkg, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.SUBPASS__DESCRIPTOR_PKG, newDescriptorPkg, newDescriptorPkg));
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
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.SUBPASS__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AttachmentRefPkg getAttachmentRefPkg()
	{
		return attachmentRefPkg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAttachmentRefPkg(AttachmentRefPkg newAttachmentRefPkg, NotificationChain msgs)
	{
		AttachmentRefPkg oldAttachmentRefPkg = attachmentRefPkg;
		attachmentRefPkg = newAttachmentRefPkg;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GraphicPackage.SUBPASS__ATTACHMENT_REF_PKG, oldAttachmentRefPkg, newAttachmentRefPkg);
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
	public void setAttachmentRefPkg(AttachmentRefPkg newAttachmentRefPkg)
	{
		if (newAttachmentRefPkg != attachmentRefPkg)
		{
			NotificationChain msgs = null;
			if (attachmentRefPkg != null)
				msgs = ((InternalEObject)attachmentRefPkg).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GraphicPackage.SUBPASS__ATTACHMENT_REF_PKG, null, msgs);
			if (newAttachmentRefPkg != null)
				msgs = ((InternalEObject)newAttachmentRefPkg).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GraphicPackage.SUBPASS__ATTACHMENT_REF_PKG, null, msgs);
			msgs = basicSetAttachmentRefPkg(newAttachmentRefPkg, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.SUBPASS__ATTACHMENT_REF_PKG, newAttachmentRefPkg, newAttachmentRefPkg));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AttachmentPkg getAttachmentPkg()
	{
		return attachmentPkg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAttachmentPkg(AttachmentPkg newAttachmentPkg, NotificationChain msgs)
	{
		AttachmentPkg oldAttachmentPkg = attachmentPkg;
		attachmentPkg = newAttachmentPkg;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GraphicPackage.SUBPASS__ATTACHMENT_PKG, oldAttachmentPkg, newAttachmentPkg);
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
	public void setAttachmentPkg(AttachmentPkg newAttachmentPkg)
	{
		if (newAttachmentPkg != attachmentPkg)
		{
			NotificationChain msgs = null;
			if (attachmentPkg != null)
				msgs = ((InternalEObject)attachmentPkg).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GraphicPackage.SUBPASS__ATTACHMENT_PKG, null, msgs);
			if (newAttachmentPkg != null)
				msgs = ((InternalEObject)newAttachmentPkg).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GraphicPackage.SUBPASS__ATTACHMENT_PKG, null, msgs);
			msgs = basicSetAttachmentPkg(newAttachmentPkg, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.SUBPASS__ATTACHMENT_PKG, newAttachmentPkg, newAttachmentPkg));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getSubpassIndex()
	{
		return subpassIndex;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSubpassIndex(int newSubpassIndex)
	{
		int oldSubpassIndex = subpassIndex;
		subpassIndex = newSubpassIndex;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.SUBPASS__SUBPASS_INDEX, oldSubpassIndex, subpassIndex));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PipelinePkg getPipelinePkg()
	{
		return pipelinePkg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPipelinePkg(PipelinePkg newPipelinePkg, NotificationChain msgs)
	{
		PipelinePkg oldPipelinePkg = pipelinePkg;
		pipelinePkg = newPipelinePkg;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GraphicPackage.SUBPASS__PIPELINE_PKG, oldPipelinePkg, newPipelinePkg);
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
	public void setPipelinePkg(PipelinePkg newPipelinePkg)
	{
		if (newPipelinePkg != pipelinePkg)
		{
			NotificationChain msgs = null;
			if (pipelinePkg != null)
				msgs = ((InternalEObject)pipelinePkg).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GraphicPackage.SUBPASS__PIPELINE_PKG, null, msgs);
			if (newPipelinePkg != null)
				msgs = ((InternalEObject)newPipelinePkg).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GraphicPackage.SUBPASS__PIPELINE_PKG, null, msgs);
			msgs = basicSetPipelinePkg(newPipelinePkg, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.SUBPASS__PIPELINE_PKG, newPipelinePkg, newPipelinePkg));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getBindPoint()
	{
		return bindPoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBindPoint(int newBindPoint)
	{
		int oldBindPoint = bindPoint;
		bindPoint = newBindPoint;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.SUBPASS__BIND_POINT, oldBindPoint, bindPoint));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ICompositor getCompositor()
	{
		if (compositor != null && ((EObject)compositor).eIsProxy())
		{
			InternalEObject oldCompositor = compositor;
			compositor = (ICompositor)eResolveProxy(oldCompositor);
			if (compositor != oldCompositor)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GraphicPackage.SUBPASS__COMPOSITOR, oldCompositor, compositor));
			}
		}
		return compositor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ICompositor basicGetCompositor()
	{
		return compositor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCompositor(ICompositor newCompositor)
	{
		ICompositor oldCompositor = compositor;
		compositor = newCompositor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.SUBPASS__COMPOSITOR, oldCompositor, compositor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EPipelineStage getWaitForStage()
	{
		return waitForStage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setWaitForStage(EPipelineStage newWaitForStage)
	{
		EPipelineStage oldWaitForStage = waitForStage;
		waitForStage = newWaitForStage == null ? WAIT_FOR_STAGE_EDEFAULT : newWaitForStage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.SUBPASS__WAIT_FOR_STAGE, oldWaitForStage, waitForStage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EPipelineStage getSyncStage()
	{
		return syncStage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSyncStage(EPipelineStage newSyncStage)
	{
		EPipelineStage oldSyncStage = syncStage;
		syncStage = newSyncStage == null ? SYNC_STAGE_EDEFAULT : newSyncStage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.SUBPASS__SYNC_STAGE, oldSyncStage, syncStage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EPipelineStage getFinishStage()
	{
		return finishStage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFinishStage(EPipelineStage newFinishStage)
	{
		EPipelineStage oldFinishStage = finishStage;
		finishStage = newFinishStage == null ? FINISH_STAGE_EDEFAULT : newFinishStage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.SUBPASS__FINISH_STAGE, oldFinishStage, finishStage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<EAccess> getWaitForAccesses()
	{
		if (waitForAccesses == null)
		{
			waitForAccesses = new EDataTypeUniqueEList<>(EAccess.class, this, GraphicPackage.SUBPASS__WAIT_FOR_ACCESSES);
		}
		return waitForAccesses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<EAccess> getSyncAccesses()
	{
		if (syncAccesses == null)
		{
			syncAccesses = new EDataTypeUniqueEList<>(EAccess.class, this, GraphicPackage.SUBPASS__SYNC_ACCESSES);
		}
		return syncAccesses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<EAccess> getFinishAccesses()
	{
		if (finishAccesses == null)
		{
			finishAccesses = new EDataTypeUniqueEList<>(EAccess.class, this, GraphicPackage.SUBPASS__FINISH_ACCESSES);
		}
		return finishAccesses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ProcessExtensionPkg getExtensionPkg()
	{
		return extensionPkg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExtensionPkg(ProcessExtensionPkg newExtensionPkg, NotificationChain msgs)
	{
		ProcessExtensionPkg oldExtensionPkg = extensionPkg;
		extensionPkg = newExtensionPkg;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GraphicPackage.SUBPASS__EXTENSION_PKG, oldExtensionPkg, newExtensionPkg);
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
	public void setExtensionPkg(ProcessExtensionPkg newExtensionPkg)
	{
		if (newExtensionPkg != extensionPkg)
		{
			NotificationChain msgs = null;
			if (extensionPkg != null)
				msgs = ((InternalEObject)extensionPkg).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GraphicPackage.SUBPASS__EXTENSION_PKG, null, msgs);
			if (newExtensionPkg != null)
				msgs = ((InternalEObject)newExtensionPkg).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GraphicPackage.SUBPASS__EXTENSION_PKG, null, msgs);
			msgs = basicSetExtensionPkg(newExtensionPkg, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.SUBPASS__EXTENSION_PKG, newExtensionPkg, newExtensionPkg));
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
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.SUBPASS__ENABLED, oldEnabled, enabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public VulkanResourcePkg getResourcePkg()
	{
		return resourcePkg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetResourcePkg(VulkanResourcePkg newResourcePkg, NotificationChain msgs)
	{
		VulkanResourcePkg oldResourcePkg = resourcePkg;
		resourcePkg = newResourcePkg;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GraphicPackage.SUBPASS__RESOURCE_PKG, oldResourcePkg, newResourcePkg);
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
	public void setResourcePkg(VulkanResourcePkg newResourcePkg)
	{
		if (newResourcePkg != resourcePkg)
		{
			NotificationChain msgs = null;
			if (resourcePkg != null)
				msgs = ((InternalEObject)resourcePkg).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GraphicPackage.SUBPASS__RESOURCE_PKG, null, msgs);
			if (newResourcePkg != null)
				msgs = ((InternalEObject)newResourcePkg).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GraphicPackage.SUBPASS__RESOURCE_PKG, null, msgs);
			msgs = basicSetResourcePkg(newResourcePkg, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.SUBPASS__RESOURCE_PKG, newResourcePkg, newResourcePkg));
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
			case GraphicPackage.SUBPASS__RESOURCE_PKG:
				return basicSetResourcePkg(null, msgs);
			case GraphicPackage.SUBPASS__DESCRIPTOR_PKG:
				return basicSetDescriptorPkg(null, msgs);
			case GraphicPackage.SUBPASS__ATTACHMENT_REF_PKG:
				return basicSetAttachmentRefPkg(null, msgs);
			case GraphicPackage.SUBPASS__ATTACHMENT_PKG:
				return basicSetAttachmentPkg(null, msgs);
			case GraphicPackage.SUBPASS__PIPELINE_PKG:
				return basicSetPipelinePkg(null, msgs);
			case GraphicPackage.SUBPASS__EXTENSION_PKG:
				return basicSetExtensionPkg(null, msgs);
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
			case GraphicPackage.SUBPASS__RESOURCE_PKG:
				return getResourcePkg();
			case GraphicPackage.SUBPASS__DESCRIPTOR_PKG:
				return getDescriptorPkg();
			case GraphicPackage.SUBPASS__NAME:
				return getName();
			case GraphicPackage.SUBPASS__ATTACHMENT_REF_PKG:
				return getAttachmentRefPkg();
			case GraphicPackage.SUBPASS__ATTACHMENT_PKG:
				return getAttachmentPkg();
			case GraphicPackage.SUBPASS__SUBPASS_INDEX:
				return getSubpassIndex();
			case GraphicPackage.SUBPASS__PIPELINE_PKG:
				return getPipelinePkg();
			case GraphicPackage.SUBPASS__BIND_POINT:
				return getBindPoint();
			case GraphicPackage.SUBPASS__COMPOSITOR:
				if (resolve) return getCompositor();
				return basicGetCompositor();
			case GraphicPackage.SUBPASS__WAIT_FOR_STAGE:
				return getWaitForStage();
			case GraphicPackage.SUBPASS__SYNC_STAGE:
				return getSyncStage();
			case GraphicPackage.SUBPASS__FINISH_STAGE:
				return getFinishStage();
			case GraphicPackage.SUBPASS__WAIT_FOR_ACCESSES:
				return getWaitForAccesses();
			case GraphicPackage.SUBPASS__SYNC_ACCESSES:
				return getSyncAccesses();
			case GraphicPackage.SUBPASS__FINISH_ACCESSES:
				return getFinishAccesses();
			case GraphicPackage.SUBPASS__EXTENSION_PKG:
				return getExtensionPkg();
			case GraphicPackage.SUBPASS__ENABLED:
				return isEnabled();
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
			case GraphicPackage.SUBPASS__RESOURCE_PKG:
				setResourcePkg((VulkanResourcePkg)newValue);
				return;
			case GraphicPackage.SUBPASS__DESCRIPTOR_PKG:
				setDescriptorPkg((DescriptorPkg)newValue);
				return;
			case GraphicPackage.SUBPASS__NAME:
				setName((String)newValue);
				return;
			case GraphicPackage.SUBPASS__ATTACHMENT_REF_PKG:
				setAttachmentRefPkg((AttachmentRefPkg)newValue);
				return;
			case GraphicPackage.SUBPASS__ATTACHMENT_PKG:
				setAttachmentPkg((AttachmentPkg)newValue);
				return;
			case GraphicPackage.SUBPASS__SUBPASS_INDEX:
				setSubpassIndex((Integer)newValue);
				return;
			case GraphicPackage.SUBPASS__PIPELINE_PKG:
				setPipelinePkg((PipelinePkg)newValue);
				return;
			case GraphicPackage.SUBPASS__BIND_POINT:
				setBindPoint((Integer)newValue);
				return;
			case GraphicPackage.SUBPASS__COMPOSITOR:
				setCompositor((ICompositor)newValue);
				return;
			case GraphicPackage.SUBPASS__WAIT_FOR_STAGE:
				setWaitForStage((EPipelineStage)newValue);
				return;
			case GraphicPackage.SUBPASS__SYNC_STAGE:
				setSyncStage((EPipelineStage)newValue);
				return;
			case GraphicPackage.SUBPASS__FINISH_STAGE:
				setFinishStage((EPipelineStage)newValue);
				return;
			case GraphicPackage.SUBPASS__WAIT_FOR_ACCESSES:
				getWaitForAccesses().clear();
				getWaitForAccesses().addAll((Collection<? extends EAccess>)newValue);
				return;
			case GraphicPackage.SUBPASS__SYNC_ACCESSES:
				getSyncAccesses().clear();
				getSyncAccesses().addAll((Collection<? extends EAccess>)newValue);
				return;
			case GraphicPackage.SUBPASS__FINISH_ACCESSES:
				getFinishAccesses().clear();
				getFinishAccesses().addAll((Collection<? extends EAccess>)newValue);
				return;
			case GraphicPackage.SUBPASS__EXTENSION_PKG:
				setExtensionPkg((ProcessExtensionPkg)newValue);
				return;
			case GraphicPackage.SUBPASS__ENABLED:
				setEnabled((Boolean)newValue);
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
			case GraphicPackage.SUBPASS__RESOURCE_PKG:
				setResourcePkg((VulkanResourcePkg)null);
				return;
			case GraphicPackage.SUBPASS__DESCRIPTOR_PKG:
				setDescriptorPkg((DescriptorPkg)null);
				return;
			case GraphicPackage.SUBPASS__NAME:
				setName(NAME_EDEFAULT);
				return;
			case GraphicPackage.SUBPASS__ATTACHMENT_REF_PKG:
				setAttachmentRefPkg((AttachmentRefPkg)null);
				return;
			case GraphicPackage.SUBPASS__ATTACHMENT_PKG:
				setAttachmentPkg((AttachmentPkg)null);
				return;
			case GraphicPackage.SUBPASS__SUBPASS_INDEX:
				setSubpassIndex(SUBPASS_INDEX_EDEFAULT);
				return;
			case GraphicPackage.SUBPASS__PIPELINE_PKG:
				setPipelinePkg((PipelinePkg)null);
				return;
			case GraphicPackage.SUBPASS__BIND_POINT:
				setBindPoint(BIND_POINT_EDEFAULT);
				return;
			case GraphicPackage.SUBPASS__COMPOSITOR:
				setCompositor((ICompositor)null);
				return;
			case GraphicPackage.SUBPASS__WAIT_FOR_STAGE:
				setWaitForStage(WAIT_FOR_STAGE_EDEFAULT);
				return;
			case GraphicPackage.SUBPASS__SYNC_STAGE:
				setSyncStage(SYNC_STAGE_EDEFAULT);
				return;
			case GraphicPackage.SUBPASS__FINISH_STAGE:
				setFinishStage(FINISH_STAGE_EDEFAULT);
				return;
			case GraphicPackage.SUBPASS__WAIT_FOR_ACCESSES:
				getWaitForAccesses().clear();
				return;
			case GraphicPackage.SUBPASS__SYNC_ACCESSES:
				getSyncAccesses().clear();
				return;
			case GraphicPackage.SUBPASS__FINISH_ACCESSES:
				getFinishAccesses().clear();
				return;
			case GraphicPackage.SUBPASS__EXTENSION_PKG:
				setExtensionPkg((ProcessExtensionPkg)null);
				return;
			case GraphicPackage.SUBPASS__ENABLED:
				setEnabled(ENABLED_EDEFAULT);
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
			case GraphicPackage.SUBPASS__RESOURCE_PKG:
				return resourcePkg != null;
			case GraphicPackage.SUBPASS__DESCRIPTOR_PKG:
				return descriptorPkg != null;
			case GraphicPackage.SUBPASS__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case GraphicPackage.SUBPASS__ATTACHMENT_REF_PKG:
				return attachmentRefPkg != null;
			case GraphicPackage.SUBPASS__ATTACHMENT_PKG:
				return attachmentPkg != null;
			case GraphicPackage.SUBPASS__SUBPASS_INDEX:
				return subpassIndex != SUBPASS_INDEX_EDEFAULT;
			case GraphicPackage.SUBPASS__PIPELINE_PKG:
				return pipelinePkg != null;
			case GraphicPackage.SUBPASS__BIND_POINT:
				return bindPoint != BIND_POINT_EDEFAULT;
			case GraphicPackage.SUBPASS__COMPOSITOR:
				return compositor != null;
			case GraphicPackage.SUBPASS__WAIT_FOR_STAGE:
				return waitForStage != WAIT_FOR_STAGE_EDEFAULT;
			case GraphicPackage.SUBPASS__SYNC_STAGE:
				return syncStage != SYNC_STAGE_EDEFAULT;
			case GraphicPackage.SUBPASS__FINISH_STAGE:
				return finishStage != FINISH_STAGE_EDEFAULT;
			case GraphicPackage.SUBPASS__WAIT_FOR_ACCESSES:
				return waitForAccesses != null && !waitForAccesses.isEmpty();
			case GraphicPackage.SUBPASS__SYNC_ACCESSES:
				return syncAccesses != null && !syncAccesses.isEmpty();
			case GraphicPackage.SUBPASS__FINISH_ACCESSES:
				return finishAccesses != null && !finishAccesses.isEmpty();
			case GraphicPackage.SUBPASS__EXTENSION_PKG:
				return extensionPkg != null;
			case GraphicPackage.SUBPASS__ENABLED:
				return enabled != ENABLED_EDEFAULT;
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
		if (baseClass == LNamedElement.class)
		{
			switch (derivedFeatureID)
			{
				case GraphicPackage.SUBPASS__NAME: return TypesPackage.LNAMED_ELEMENT__NAME;
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
		if (baseClass == LNamedElement.class)
		{
			switch (baseFeatureID)
			{
				case TypesPackage.LNAMED_ELEMENT__NAME: return GraphicPackage.SUBPASS__NAME;
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
		result.append(", subpassIndex: ");
		result.append(subpassIndex);
		result.append(", bindPoint: ");
		result.append(bindPoint);
		result.append(", waitForStage: ");
		result.append(waitForStage);
		result.append(", syncStage: ");
		result.append(syncStage);
		result.append(", finishStage: ");
		result.append(finishStage);
		result.append(", waitForAccesses: ");
		result.append(waitForAccesses);
		result.append(", syncAccesses: ");
		result.append(syncAccesses);
		result.append(", finishAccesses: ");
		result.append(finishAccesses);
		result.append(", enabled: ");
		result.append(enabled);
		result.append(')');
		return result.toString();
	}

} //SubpassImpl
