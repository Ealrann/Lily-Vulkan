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
import org.sheepy.lily.core.api.adapter.LilyEObject;
import org.sheepy.lily.core.model.application.IScenePart;
import org.sheepy.lily.core.model.resource.ResourcePkg;
import org.sheepy.lily.core.model.types.LNamedElement;
import org.sheepy.lily.core.model.types.TypesPackage;
import org.sheepy.lily.vulkan.model.DescriptorPkg;
import org.sheepy.lily.vulkan.model.process.PipelinePkg;
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
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.SubpassImpl#getAttachmantRefPkg <em>Attachmant Ref Pkg</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.SubpassImpl#getSubpassIndex <em>Subpass Index</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.SubpassImpl#getStages <em>Stages</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.SubpassImpl#getAccesses <em>Accesses</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.SubpassImpl#getPipelinePkg <em>Pipeline Pkg</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.SubpassImpl#getBindPoint <em>Bind Point</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.SubpassImpl#getScenePart <em>Scene Part</em>}</li>
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
	 * The cached value of the '{@link #getAttachmantRefPkg() <em>Attachmant Ref Pkg</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttachmantRefPkg()
	 * @generated
	 * @ordered
	 */
	protected AttachmentRefPkg attachmantRefPkg;

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
	 * The cached value of the '{@link #getStages() <em>Stages</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStages()
	 * @generated
	 * @ordered
	 */
	protected EList<EPipelineStage> stages;

	/**
	 * The cached value of the '{@link #getAccesses() <em>Accesses</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAccesses()
	 * @generated
	 * @ordered
	 */
	protected EList<EAccess> accesses;

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
	 * The cached value of the '{@link #getScenePart() <em>Scene Part</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScenePart()
	 * @generated
	 * @ordered
	 */
	protected IScenePart scenePart;

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
	public void setResourcePkg(ResourcePkg newResourcePkg)
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
	public AttachmentRefPkg getAttachmantRefPkg()
	{
		return attachmantRefPkg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAttachmantRefPkg(AttachmentRefPkg newAttachmantRefPkg, NotificationChain msgs)
	{
		AttachmentRefPkg oldAttachmantRefPkg = attachmantRefPkg;
		attachmantRefPkg = newAttachmantRefPkg;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GraphicPackage.SUBPASS__ATTACHMANT_REF_PKG, oldAttachmantRefPkg, newAttachmantRefPkg);
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
	public void setAttachmantRefPkg(AttachmentRefPkg newAttachmantRefPkg)
	{
		if (newAttachmantRefPkg != attachmantRefPkg)
		{
			NotificationChain msgs = null;
			if (attachmantRefPkg != null)
				msgs = ((InternalEObject)attachmantRefPkg).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GraphicPackage.SUBPASS__ATTACHMANT_REF_PKG, null, msgs);
			if (newAttachmantRefPkg != null)
				msgs = ((InternalEObject)newAttachmantRefPkg).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GraphicPackage.SUBPASS__ATTACHMANT_REF_PKG, null, msgs);
			msgs = basicSetAttachmantRefPkg(newAttachmantRefPkg, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.SUBPASS__ATTACHMANT_REF_PKG, newAttachmantRefPkg, newAttachmantRefPkg));
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
	public EList<EPipelineStage> getStages()
	{
		if (stages == null)
		{
			stages = new EDataTypeUniqueEList<EPipelineStage>(EPipelineStage.class, this, GraphicPackage.SUBPASS__STAGES);
		}
		return stages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<EAccess> getAccesses()
	{
		if (accesses == null)
		{
			accesses = new EDataTypeUniqueEList<EAccess>(EAccess.class, this, GraphicPackage.SUBPASS__ACCESSES);
		}
		return accesses;
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
	public IScenePart getScenePart()
	{
		if (scenePart != null && ((EObject)scenePart).eIsProxy())
		{
			InternalEObject oldScenePart = (InternalEObject)scenePart;
			scenePart = (IScenePart)eResolveProxy(oldScenePart);
			if (scenePart != oldScenePart)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GraphicPackage.SUBPASS__SCENE_PART, oldScenePart, scenePart));
			}
		}
		return scenePart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IScenePart basicGetScenePart()
	{
		return scenePart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setScenePart(IScenePart newScenePart)
	{
		IScenePart oldScenePart = scenePart;
		scenePart = newScenePart;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.SUBPASS__SCENE_PART, oldScenePart, scenePart));
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
			case GraphicPackage.SUBPASS__ATTACHMANT_REF_PKG:
				return basicSetAttachmantRefPkg(null, msgs);
			case GraphicPackage.SUBPASS__PIPELINE_PKG:
				return basicSetPipelinePkg(null, msgs);
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
			case GraphicPackage.SUBPASS__ATTACHMANT_REF_PKG:
				return getAttachmantRefPkg();
			case GraphicPackage.SUBPASS__SUBPASS_INDEX:
				return getSubpassIndex();
			case GraphicPackage.SUBPASS__STAGES:
				return getStages();
			case GraphicPackage.SUBPASS__ACCESSES:
				return getAccesses();
			case GraphicPackage.SUBPASS__PIPELINE_PKG:
				return getPipelinePkg();
			case GraphicPackage.SUBPASS__BIND_POINT:
				return getBindPoint();
			case GraphicPackage.SUBPASS__SCENE_PART:
				if (resolve) return getScenePart();
				return basicGetScenePart();
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
				setResourcePkg((ResourcePkg)newValue);
				return;
			case GraphicPackage.SUBPASS__DESCRIPTOR_PKG:
				setDescriptorPkg((DescriptorPkg)newValue);
				return;
			case GraphicPackage.SUBPASS__NAME:
				setName((String)newValue);
				return;
			case GraphicPackage.SUBPASS__ATTACHMANT_REF_PKG:
				setAttachmantRefPkg((AttachmentRefPkg)newValue);
				return;
			case GraphicPackage.SUBPASS__SUBPASS_INDEX:
				setSubpassIndex((Integer)newValue);
				return;
			case GraphicPackage.SUBPASS__STAGES:
				getStages().clear();
				getStages().addAll((Collection<? extends EPipelineStage>)newValue);
				return;
			case GraphicPackage.SUBPASS__ACCESSES:
				getAccesses().clear();
				getAccesses().addAll((Collection<? extends EAccess>)newValue);
				return;
			case GraphicPackage.SUBPASS__PIPELINE_PKG:
				setPipelinePkg((PipelinePkg)newValue);
				return;
			case GraphicPackage.SUBPASS__BIND_POINT:
				setBindPoint((Integer)newValue);
				return;
			case GraphicPackage.SUBPASS__SCENE_PART:
				setScenePart((IScenePart)newValue);
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
				setResourcePkg((ResourcePkg)null);
				return;
			case GraphicPackage.SUBPASS__DESCRIPTOR_PKG:
				setDescriptorPkg((DescriptorPkg)null);
				return;
			case GraphicPackage.SUBPASS__NAME:
				setName(NAME_EDEFAULT);
				return;
			case GraphicPackage.SUBPASS__ATTACHMANT_REF_PKG:
				setAttachmantRefPkg((AttachmentRefPkg)null);
				return;
			case GraphicPackage.SUBPASS__SUBPASS_INDEX:
				setSubpassIndex(SUBPASS_INDEX_EDEFAULT);
				return;
			case GraphicPackage.SUBPASS__STAGES:
				getStages().clear();
				return;
			case GraphicPackage.SUBPASS__ACCESSES:
				getAccesses().clear();
				return;
			case GraphicPackage.SUBPASS__PIPELINE_PKG:
				setPipelinePkg((PipelinePkg)null);
				return;
			case GraphicPackage.SUBPASS__BIND_POINT:
				setBindPoint(BIND_POINT_EDEFAULT);
				return;
			case GraphicPackage.SUBPASS__SCENE_PART:
				setScenePart((IScenePart)null);
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
			case GraphicPackage.SUBPASS__ATTACHMANT_REF_PKG:
				return attachmantRefPkg != null;
			case GraphicPackage.SUBPASS__SUBPASS_INDEX:
				return subpassIndex != SUBPASS_INDEX_EDEFAULT;
			case GraphicPackage.SUBPASS__STAGES:
				return stages != null && !stages.isEmpty();
			case GraphicPackage.SUBPASS__ACCESSES:
				return accesses != null && !accesses.isEmpty();
			case GraphicPackage.SUBPASS__PIPELINE_PKG:
				return pipelinePkg != null;
			case GraphicPackage.SUBPASS__BIND_POINT:
				return bindPoint != BIND_POINT_EDEFAULT;
			case GraphicPackage.SUBPASS__SCENE_PART:
				return scenePart != null;
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
		result.append(", stages: ");
		result.append(stages);
		result.append(", accesses: ");
		result.append(accesses);
		result.append(", bindPoint: ");
		result.append(bindPoint);
		result.append(')');
		return result.toString();
	}

} //SubpassImpl
