/**
 */
package org.sheepy.lily.vulkan.extra.model.rendering.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.sheepy.lily.core.api.model.LilyEObject;
import org.sheepy.lily.vulkan.extra.model.rendering.EntityResolverPipeline;
import org.sheepy.lily.vulkan.extra.model.rendering.MousePickExtension;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage;
import org.sheepy.lily.vulkan.extra.model.rendering.SelectionProxy;
import org.sheepy.lily.vulkan.model.vulkanresource.StaticBuffer;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mouse Pick Extension</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.MousePickExtensionImpl#getMousePickBuffer <em>Mouse Pick Buffer</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.MousePickExtensionImpl#getSelectionProxy <em>Selection Proxy</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.MousePickExtensionImpl#getEntityResolverPipelines <em>Entity Resolver Pipelines</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.MousePickExtensionImpl#getResolverPipelineOffset <em>Resolver Pipeline Offset</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MousePickExtensionImpl extends LilyEObject implements MousePickExtension
{
	/**
	 * The cached value of the '{@link #getMousePickBuffer() <em>Mouse Pick Buffer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMousePickBuffer()
	 * @generated
	 * @ordered
	 */
	protected StaticBuffer mousePickBuffer;

	/**
	 * The cached value of the '{@link #getSelectionProxy() <em>Selection Proxy</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSelectionProxy()
	 * @generated
	 * @ordered
	 */
	protected SelectionProxy selectionProxy;

	/**
	 * The cached value of the '{@link #getEntityResolverPipelines() <em>Entity Resolver Pipelines</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEntityResolverPipelines()
	 * @generated
	 * @ordered
	 */
	protected EList<EntityResolverPipeline> entityResolverPipelines;

	/**
	 * The default value of the '{@link #getResolverPipelineOffset() <em>Resolver Pipeline Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResolverPipelineOffset()
	 * @generated
	 * @ordered
	 */
	protected static final int RESOLVER_PIPELINE_OFFSET_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getResolverPipelineOffset() <em>Resolver Pipeline Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResolverPipelineOffset()
	 * @generated
	 * @ordered
	 */
	protected int resolverPipelineOffset = RESOLVER_PIPELINE_OFFSET_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MousePickExtensionImpl()
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
		return RenderingPackage.Literals.MOUSE_PICK_EXTENSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public StaticBuffer getMousePickBuffer()
	{
		if (mousePickBuffer != null && ((EObject)mousePickBuffer).eIsProxy())
		{
			InternalEObject oldMousePickBuffer = mousePickBuffer;
			mousePickBuffer = (StaticBuffer)eResolveProxy(oldMousePickBuffer);
			if (mousePickBuffer != oldMousePickBuffer)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RenderingPackage.MOUSE_PICK_EXTENSION__MOUSE_PICK_BUFFER, oldMousePickBuffer, mousePickBuffer));
			}
		}
		return mousePickBuffer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StaticBuffer basicGetMousePickBuffer()
	{
		return mousePickBuffer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMousePickBuffer(StaticBuffer newMousePickBuffer)
	{
		StaticBuffer oldMousePickBuffer = mousePickBuffer;
		mousePickBuffer = newMousePickBuffer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RenderingPackage.MOUSE_PICK_EXTENSION__MOUSE_PICK_BUFFER, oldMousePickBuffer, mousePickBuffer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SelectionProxy getSelectionProxy()
	{
		if (selectionProxy != null && ((EObject)selectionProxy).eIsProxy())
		{
			InternalEObject oldSelectionProxy = selectionProxy;
			selectionProxy = (SelectionProxy)eResolveProxy(oldSelectionProxy);
			if (selectionProxy != oldSelectionProxy)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RenderingPackage.MOUSE_PICK_EXTENSION__SELECTION_PROXY, oldSelectionProxy, selectionProxy));
			}
		}
		return selectionProxy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SelectionProxy basicGetSelectionProxy()
	{
		return selectionProxy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSelectionProxy(SelectionProxy newSelectionProxy)
	{
		SelectionProxy oldSelectionProxy = selectionProxy;
		selectionProxy = newSelectionProxy;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RenderingPackage.MOUSE_PICK_EXTENSION__SELECTION_PROXY, oldSelectionProxy, selectionProxy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<EntityResolverPipeline> getEntityResolverPipelines()
	{
		if (entityResolverPipelines == null)
		{
			entityResolverPipelines = new EObjectContainmentEList<>(EntityResolverPipeline.class, this, RenderingPackage.MOUSE_PICK_EXTENSION__ENTITY_RESOLVER_PIPELINES);
		}
		return entityResolverPipelines;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getResolverPipelineOffset()
	{
		return resolverPipelineOffset;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setResolverPipelineOffset(int newResolverPipelineOffset)
	{
		int oldResolverPipelineOffset = resolverPipelineOffset;
		resolverPipelineOffset = newResolverPipelineOffset;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RenderingPackage.MOUSE_PICK_EXTENSION__RESOLVER_PIPELINE_OFFSET, oldResolverPipelineOffset, resolverPipelineOffset));
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
			case RenderingPackage.MOUSE_PICK_EXTENSION__ENTITY_RESOLVER_PIPELINES:
				return ((InternalEList<?>)getEntityResolverPipelines()).basicRemove(otherEnd, msgs);
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
			case RenderingPackage.MOUSE_PICK_EXTENSION__MOUSE_PICK_BUFFER:
				if (resolve) return getMousePickBuffer();
				return basicGetMousePickBuffer();
			case RenderingPackage.MOUSE_PICK_EXTENSION__SELECTION_PROXY:
				if (resolve) return getSelectionProxy();
				return basicGetSelectionProxy();
			case RenderingPackage.MOUSE_PICK_EXTENSION__ENTITY_RESOLVER_PIPELINES:
				return getEntityResolverPipelines();
			case RenderingPackage.MOUSE_PICK_EXTENSION__RESOLVER_PIPELINE_OFFSET:
				return getResolverPipelineOffset();
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
			case RenderingPackage.MOUSE_PICK_EXTENSION__MOUSE_PICK_BUFFER:
				setMousePickBuffer((StaticBuffer)newValue);
				return;
			case RenderingPackage.MOUSE_PICK_EXTENSION__SELECTION_PROXY:
				setSelectionProxy((SelectionProxy)newValue);
				return;
			case RenderingPackage.MOUSE_PICK_EXTENSION__ENTITY_RESOLVER_PIPELINES:
				getEntityResolverPipelines().clear();
				getEntityResolverPipelines().addAll((Collection<? extends EntityResolverPipeline>)newValue);
				return;
			case RenderingPackage.MOUSE_PICK_EXTENSION__RESOLVER_PIPELINE_OFFSET:
				setResolverPipelineOffset((Integer)newValue);
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
			case RenderingPackage.MOUSE_PICK_EXTENSION__MOUSE_PICK_BUFFER:
				setMousePickBuffer((StaticBuffer)null);
				return;
			case RenderingPackage.MOUSE_PICK_EXTENSION__SELECTION_PROXY:
				setSelectionProxy((SelectionProxy)null);
				return;
			case RenderingPackage.MOUSE_PICK_EXTENSION__ENTITY_RESOLVER_PIPELINES:
				getEntityResolverPipelines().clear();
				return;
			case RenderingPackage.MOUSE_PICK_EXTENSION__RESOLVER_PIPELINE_OFFSET:
				setResolverPipelineOffset(RESOLVER_PIPELINE_OFFSET_EDEFAULT);
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
			case RenderingPackage.MOUSE_PICK_EXTENSION__MOUSE_PICK_BUFFER:
				return mousePickBuffer != null;
			case RenderingPackage.MOUSE_PICK_EXTENSION__SELECTION_PROXY:
				return selectionProxy != null;
			case RenderingPackage.MOUSE_PICK_EXTENSION__ENTITY_RESOLVER_PIPELINES:
				return entityResolverPipelines != null && !entityResolverPipelines.isEmpty();
			case RenderingPackage.MOUSE_PICK_EXTENSION__RESOLVER_PIPELINE_OFFSET:
				return resolverPipelineOffset != RESOLVER_PIPELINE_OFFSET_EDEFAULT;
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
		result.append(" (resolverPipelineOffset: ");
		result.append(resolverPipelineOffset);
		result.append(')');
		return result.toString();
	}

} //MousePickExtensionImpl
