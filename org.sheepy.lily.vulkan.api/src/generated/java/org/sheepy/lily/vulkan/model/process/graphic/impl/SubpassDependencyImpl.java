/**
 */
package org.sheepy.lily.vulkan.model.process.graphic.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.lily.vulkan.model.process.graphic.Subpass;
import org.sheepy.lily.vulkan.model.process.graphic.SubpassDependency;

import org.sheepy.vulkan.model.enumeration.EAccess;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Subpass Dependency</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.SubpassDependencyImpl#getSrcSubpass <em>Src Subpass</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.SubpassDependencyImpl#getDstSubpass <em>Dst Subpass</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.SubpassDependencyImpl#getSrcStageMask <em>Src Stage Mask</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.SubpassDependencyImpl#getDstStageMask <em>Dst Stage Mask</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.SubpassDependencyImpl#getSrcAccesses <em>Src Accesses</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.SubpassDependencyImpl#getDstAccesses <em>Dst Accesses</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SubpassDependencyImpl extends MinimalEObjectImpl.Container implements SubpassDependency
{
	/**
	 * The cached value of the '{@link #getSrcSubpass() <em>Src Subpass</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSrcSubpass()
	 * @generated
	 * @ordered
	 */
	protected Subpass srcSubpass;

	/**
	 * The cached value of the '{@link #getDstSubpass() <em>Dst Subpass</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDstSubpass()
	 * @generated
	 * @ordered
	 */
	protected Subpass dstSubpass;

	/**
	 * The cached value of the '{@link #getSrcStageMask() <em>Src Stage Mask</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSrcStageMask()
	 * @generated
	 * @ordered
	 */
	protected EList<EPipelineStage> srcStageMask;

	/**
	 * The cached value of the '{@link #getDstStageMask() <em>Dst Stage Mask</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDstStageMask()
	 * @generated
	 * @ordered
	 */
	protected EList<EPipelineStage> dstStageMask;

	/**
	 * The cached value of the '{@link #getSrcAccesses() <em>Src Accesses</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSrcAccesses()
	 * @generated
	 * @ordered
	 */
	protected EList<EAccess> srcAccesses;

	/**
	 * The cached value of the '{@link #getDstAccesses() <em>Dst Accesses</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDstAccesses()
	 * @generated
	 * @ordered
	 */
	protected EList<EAccess> dstAccesses;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SubpassDependencyImpl()
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
		return GraphicPackage.Literals.SUBPASS_DEPENDENCY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Subpass getSrcSubpass()
	{
		if (srcSubpass != null && srcSubpass.eIsProxy())
		{
			InternalEObject oldSrcSubpass = (InternalEObject) srcSubpass;
			srcSubpass = (Subpass) eResolveProxy(oldSrcSubpass);
			if (srcSubpass != oldSrcSubpass)
			{
				if (eNotificationRequired()) eNotify(new ENotificationImpl(this,
						Notification.RESOLVE, GraphicPackage.SUBPASS_DEPENDENCY__SRC_SUBPASS,
						oldSrcSubpass, srcSubpass));
			}
		}
		return srcSubpass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Subpass basicGetSrcSubpass()
	{
		return srcSubpass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSrcSubpass(Subpass newSrcSubpass)
	{
		Subpass oldSrcSubpass = srcSubpass;
		srcSubpass = newSrcSubpass;
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				GraphicPackage.SUBPASS_DEPENDENCY__SRC_SUBPASS, oldSrcSubpass, srcSubpass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Subpass getDstSubpass()
	{
		if (dstSubpass != null && dstSubpass.eIsProxy())
		{
			InternalEObject oldDstSubpass = (InternalEObject) dstSubpass;
			dstSubpass = (Subpass) eResolveProxy(oldDstSubpass);
			if (dstSubpass != oldDstSubpass)
			{
				if (eNotificationRequired()) eNotify(new ENotificationImpl(this,
						Notification.RESOLVE, GraphicPackage.SUBPASS_DEPENDENCY__DST_SUBPASS,
						oldDstSubpass, dstSubpass));
			}
		}
		return dstSubpass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Subpass basicGetDstSubpass()
	{
		return dstSubpass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDstSubpass(Subpass newDstSubpass)
	{
		Subpass oldDstSubpass = dstSubpass;
		dstSubpass = newDstSubpass;
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				GraphicPackage.SUBPASS_DEPENDENCY__DST_SUBPASS, oldDstSubpass, dstSubpass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<EPipelineStage> getSrcStageMask()
	{
		if (srcStageMask == null)
		{
			srcStageMask = new EDataTypeUniqueEList<EPipelineStage>(EPipelineStage.class, this,
					GraphicPackage.SUBPASS_DEPENDENCY__SRC_STAGE_MASK);
		}
		return srcStageMask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<EPipelineStage> getDstStageMask()
	{
		if (dstStageMask == null)
		{
			dstStageMask = new EDataTypeUniqueEList<EPipelineStage>(EPipelineStage.class, this,
					GraphicPackage.SUBPASS_DEPENDENCY__DST_STAGE_MASK);
		}
		return dstStageMask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<EAccess> getSrcAccesses()
	{
		if (srcAccesses == null)
		{
			srcAccesses = new EDataTypeUniqueEList<EAccess>(EAccess.class, this,
					GraphicPackage.SUBPASS_DEPENDENCY__SRC_ACCESSES);
		}
		return srcAccesses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<EAccess> getDstAccesses()
	{
		if (dstAccesses == null)
		{
			dstAccesses = new EDataTypeUniqueEList<EAccess>(EAccess.class, this,
					GraphicPackage.SUBPASS_DEPENDENCY__DST_ACCESSES);
		}
		return dstAccesses;
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
		case GraphicPackage.SUBPASS_DEPENDENCY__SRC_SUBPASS:
			if (resolve) return getSrcSubpass();
			return basicGetSrcSubpass();
		case GraphicPackage.SUBPASS_DEPENDENCY__DST_SUBPASS:
			if (resolve) return getDstSubpass();
			return basicGetDstSubpass();
		case GraphicPackage.SUBPASS_DEPENDENCY__SRC_STAGE_MASK:
			return getSrcStageMask();
		case GraphicPackage.SUBPASS_DEPENDENCY__DST_STAGE_MASK:
			return getDstStageMask();
		case GraphicPackage.SUBPASS_DEPENDENCY__SRC_ACCESSES:
			return getSrcAccesses();
		case GraphicPackage.SUBPASS_DEPENDENCY__DST_ACCESSES:
			return getDstAccesses();
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
		case GraphicPackage.SUBPASS_DEPENDENCY__SRC_SUBPASS:
			setSrcSubpass((Subpass) newValue);
			return;
		case GraphicPackage.SUBPASS_DEPENDENCY__DST_SUBPASS:
			setDstSubpass((Subpass) newValue);
			return;
		case GraphicPackage.SUBPASS_DEPENDENCY__SRC_STAGE_MASK:
			getSrcStageMask().clear();
			getSrcStageMask().addAll((Collection<? extends EPipelineStage>) newValue);
			return;
		case GraphicPackage.SUBPASS_DEPENDENCY__DST_STAGE_MASK:
			getDstStageMask().clear();
			getDstStageMask().addAll((Collection<? extends EPipelineStage>) newValue);
			return;
		case GraphicPackage.SUBPASS_DEPENDENCY__SRC_ACCESSES:
			getSrcAccesses().clear();
			getSrcAccesses().addAll((Collection<? extends EAccess>) newValue);
			return;
		case GraphicPackage.SUBPASS_DEPENDENCY__DST_ACCESSES:
			getDstAccesses().clear();
			getDstAccesses().addAll((Collection<? extends EAccess>) newValue);
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
		case GraphicPackage.SUBPASS_DEPENDENCY__SRC_SUBPASS:
			setSrcSubpass((Subpass) null);
			return;
		case GraphicPackage.SUBPASS_DEPENDENCY__DST_SUBPASS:
			setDstSubpass((Subpass) null);
			return;
		case GraphicPackage.SUBPASS_DEPENDENCY__SRC_STAGE_MASK:
			getSrcStageMask().clear();
			return;
		case GraphicPackage.SUBPASS_DEPENDENCY__DST_STAGE_MASK:
			getDstStageMask().clear();
			return;
		case GraphicPackage.SUBPASS_DEPENDENCY__SRC_ACCESSES:
			getSrcAccesses().clear();
			return;
		case GraphicPackage.SUBPASS_DEPENDENCY__DST_ACCESSES:
			getDstAccesses().clear();
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
		case GraphicPackage.SUBPASS_DEPENDENCY__SRC_SUBPASS:
			return srcSubpass != null;
		case GraphicPackage.SUBPASS_DEPENDENCY__DST_SUBPASS:
			return dstSubpass != null;
		case GraphicPackage.SUBPASS_DEPENDENCY__SRC_STAGE_MASK:
			return srcStageMask != null && !srcStageMask.isEmpty();
		case GraphicPackage.SUBPASS_DEPENDENCY__DST_STAGE_MASK:
			return dstStageMask != null && !dstStageMask.isEmpty();
		case GraphicPackage.SUBPASS_DEPENDENCY__SRC_ACCESSES:
			return srcAccesses != null && !srcAccesses.isEmpty();
		case GraphicPackage.SUBPASS_DEPENDENCY__DST_ACCESSES:
			return dstAccesses != null && !dstAccesses.isEmpty();
		}
		return super.eIsSet(featureID);
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
		result.append(" (srcStageMask: ");
		result.append(srcStageMask);
		result.append(", dstStageMask: ");
		result.append(dstStageMask);
		result.append(", srcAccesses: ");
		result.append(srcAccesses);
		result.append(", dstAccesses: ");
		result.append(dstAccesses);
		result.append(')');
		return result.toString();
	}

} //SubpassDependencyImpl
